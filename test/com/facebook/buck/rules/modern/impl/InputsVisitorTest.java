/*
 * Copyright 2018-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.rules.modern.impl;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import com.facebook.buck.model.BuildTargetFactory;
import com.facebook.buck.rules.AddToRuleKey;
import com.facebook.buck.rules.AddsToRuleKey;
import com.facebook.buck.rules.DefaultBuildTargetSourcePath;
import com.facebook.buck.rules.FakeSourcePath;
import com.facebook.buck.rules.HasCustomInputsLogic;
import com.facebook.buck.rules.PathSourcePath;
import com.facebook.buck.rules.SourcePath;
import com.facebook.buck.rules.modern.Buildable;
import com.facebook.buck.rules.modern.CustomFieldInputs;
import com.facebook.buck.rules.modern.annotations.CustomFieldBehavior;
import com.facebook.buck.util.function.ThrowingConsumer;
import com.google.common.collect.ImmutableList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.Test;

public class InputsVisitorTest extends AbstractValueVisitorTest {
  private Consumer<SourcePath> inputsConsumer = createStrictMock(Consumer.class);

  private void apply(Buildable value) {
    replay(inputsConsumer);
    DefaultClassInfoFactory.forInstance(value).visit(value, new InputsVisitor(inputsConsumer));
    verify(inputsConsumer);
  }

  @Override
  @Test
  public void outputPath() {
    apply(new WithOutputPath());
  }

  @Override
  @Test
  public void sourcePath() {
    WithSourcePath value = new WithSourcePath();
    inputsConsumer.accept(value.path);
    apply(value);
  }

  @Override
  @Test
  public void set() {
    apply(new WithSet());
  }

  @Override
  @Test
  public void addsToRuleKey() {
    inputsConsumer.accept(anyObject());
    expectLastCall().times(3);
    apply(new WithAddsToRuleKey());
  }

  @Override
  @Test
  public void pattern() throws Exception {
    apply(new WithPattern());
  }

  @Override
  @Test
  public void anEnum() throws Exception {
    apply(new WithEnum());
  }

  @Override
  @Test
  public void nonHashableSourcePathContainer() throws Exception {
    WithNonHashableSourcePathContainer value = new WithNonHashableSourcePathContainer();
    inputsConsumer.accept(value.container.getSourcePath());
    apply(value);
  }

  @Override
  @Test
  public void sortedMap() throws Exception {
    inputsConsumer.accept(anyObject());
    expectLastCall().times(2);
    apply(new WithSortedMap());
  }

  @Override
  @Test
  public void supplier() throws Exception {
    inputsConsumer.accept(anyObject());
    apply(new WithSupplier());
  }

  @Override
  @Test
  public void nullable() throws Exception {
    inputsConsumer.accept(anyObject());
    apply(new WithNullable());
  }

  @Override
  @Test
  public void either() throws Exception {
    inputsConsumer.accept(anyObject());
    apply(new WithEither());
  }

  @Override
  @Test
  public void excluded() throws Exception {
    apply(new WithExcluded());
  }

  @Override
  @Test
  public void immutables() throws Exception {
    inputsConsumer.accept(anyObject());
    expectLastCall().times(4);
    apply(new WithImmutables());
  }

  static class WithSourcePathList implements FakeBuildable {
    @AddToRuleKey private final ImmutableList<SourcePath> inputs;

    WithSourcePathList(ImmutableList<SourcePath> inputs) {
      this.inputs = inputs;
    }
  }

  @Override
  @Test
  public void list() {
    PathSourcePath fakePath = FakeSourcePath.of("some/path");
    DefaultBuildTargetSourcePath targetPath =
        DefaultBuildTargetSourcePath.of(BuildTargetFactory.newInstance("//some:target"));
    inputsConsumer.accept(fakePath);
    inputsConsumer.accept(targetPath);
    apply(new WithSourcePathList(ImmutableList.of(fakePath, targetPath)));
  }

  @Override
  @Test
  public void optional() {
    apply(new WithOptional());
  }

  @Override
  @Test
  public void simple() {
    apply(new Simple());
  }

  @Override
  @Test
  public void superClass() {
    apply(new TwiceDerived());
  }

  @Override
  @Test
  public void empty() {
    apply(new Empty());
  }

  @Override
  @Test
  public void complex() {
    Complex value = new Complex();
    inputsConsumer.accept(anyObject());
    expectLastCall().times(3);
    apply(value);
  }

  @Test
  @Override
  public void buildTarget() {
    apply(new WithBuildTarget());
  }

  private static final PathSourcePath otherPath = FakeSourcePath.of("some.path");;

  private static class HasCustomInputs implements AddsToRuleKey, HasCustomInputsLogic {
    @AddToRuleKey
    private final SourcePath sourcePath = DefaultBuildTargetSourcePath.of(someBuildTarget);

    @Override
    public <E extends Exception> void computeInputs(ThrowingConsumer<SourcePath, E> consumer)
        throws E {
      consumer.accept(otherPath);
    }
  }

  private static class WithCustomInputs implements AddsToRuleKey {
    @AddToRuleKey private final HasCustomInputs hasCustomInputs = new HasCustomInputs();
  }

  @Test
  public void customDeps() {
    WithCustomInputs withCustomInputs = new WithCustomInputs();
    ImmutableList.Builder<SourcePath> inputsBuilder = ImmutableList.builder();
    DefaultClassInfoFactory.forInstance(withCustomInputs)
        .visit(withCustomInputs, new InputsVisitor(inputsBuilder::add));
    assertEquals(inputsBuilder.build(), ImmutableList.of(otherPath));
  }

  @Test
  public void customFieldBehavior() {
    WithCustomFieldBehavior withCustomFieldBehavior = new WithCustomFieldBehavior();
    InjectableInputsBehavior.function =
        (string, consumer) -> {
          assertEquals("value", string);
          consumer.accept(otherPath);
        };

    ImmutableList.Builder<SourcePath> inputsBuilder = ImmutableList.builder();
    DefaultClassInfoFactory.forInstance(withCustomFieldBehavior)
        .visit(withCustomFieldBehavior, new InputsVisitor(inputsBuilder::add));
    assertEquals(ImmutableList.of(otherPath), inputsBuilder.build());
  }

  private static class WithCustomFieldBehavior implements AddsToRuleKey {
    @CustomFieldBehavior(IgnoredForInputsBehavior.class)
    @AddToRuleKey
    private final SourcePath sourcePath = DefaultBuildTargetSourcePath.of(someBuildTarget);

    @CustomFieldBehavior(InjectableInputsBehavior.class)
    @AddToRuleKey
    private final String value = "value";
  }

  private static class IgnoredForInputsBehavior implements CustomFieldInputs<SourcePath> {
    @Override
    public void getInputs(SourcePath value, Consumer<SourcePath> consumer) {
      // ignored for inputs.
    }
  }

  private static class InjectableInputsBehavior implements CustomFieldInputs<String> {
    private static BiConsumer<String, Consumer<SourcePath>> function = (s, c) -> {};

    @Override
    public void getInputs(String value, Consumer<SourcePath> consumer) {
      function.accept(value, consumer);
    }
  }
}
