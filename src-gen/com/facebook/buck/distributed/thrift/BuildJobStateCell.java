/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.buck.distributed.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-11-07")
public class BuildJobStateCell implements org.apache.thrift.TBase<BuildJobStateCell, BuildJobStateCell._Fields>, java.io.Serializable, Cloneable, Comparable<BuildJobStateCell> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BuildJobStateCell");

  private static final org.apache.thrift.protocol.TField NAME_HINT_FIELD_DESC = new org.apache.thrift.protocol.TField("nameHint", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CONFIG_FIELD_DESC = new org.apache.thrift.protocol.TField("config", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BuildJobStateCellStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BuildJobStateCellTupleSchemeFactory());
  }

  public String nameHint; // optional
  public BuildJobStateBuckConfig config; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME_HINT((short)1, "nameHint"),
    CONFIG((short)2, "config");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NAME_HINT
          return NAME_HINT;
        case 2: // CONFIG
          return CONFIG;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.NAME_HINT,_Fields.CONFIG};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME_HINT, new org.apache.thrift.meta_data.FieldMetaData("nameHint", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CONFIG, new org.apache.thrift.meta_data.FieldMetaData("config", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BuildJobStateBuckConfig.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BuildJobStateCell.class, metaDataMap);
  }

  public BuildJobStateCell() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BuildJobStateCell(BuildJobStateCell other) {
    if (other.isSetNameHint()) {
      this.nameHint = other.nameHint;
    }
    if (other.isSetConfig()) {
      this.config = new BuildJobStateBuckConfig(other.config);
    }
  }

  public BuildJobStateCell deepCopy() {
    return new BuildJobStateCell(this);
  }

  @Override
  public void clear() {
    this.nameHint = null;
    this.config = null;
  }

  public String getNameHint() {
    return this.nameHint;
  }

  public BuildJobStateCell setNameHint(String nameHint) {
    this.nameHint = nameHint;
    return this;
  }

  public void unsetNameHint() {
    this.nameHint = null;
  }

  /** Returns true if field nameHint is set (has been assigned a value) and false otherwise */
  public boolean isSetNameHint() {
    return this.nameHint != null;
  }

  public void setNameHintIsSet(boolean value) {
    if (!value) {
      this.nameHint = null;
    }
  }

  public BuildJobStateBuckConfig getConfig() {
    return this.config;
  }

  public BuildJobStateCell setConfig(BuildJobStateBuckConfig config) {
    this.config = config;
    return this;
  }

  public void unsetConfig() {
    this.config = null;
  }

  /** Returns true if field config is set (has been assigned a value) and false otherwise */
  public boolean isSetConfig() {
    return this.config != null;
  }

  public void setConfigIsSet(boolean value) {
    if (!value) {
      this.config = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME_HINT:
      if (value == null) {
        unsetNameHint();
      } else {
        setNameHint((String)value);
      }
      break;

    case CONFIG:
      if (value == null) {
        unsetConfig();
      } else {
        setConfig((BuildJobStateBuckConfig)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME_HINT:
      return getNameHint();

    case CONFIG:
      return getConfig();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME_HINT:
      return isSetNameHint();
    case CONFIG:
      return isSetConfig();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BuildJobStateCell)
      return this.equals((BuildJobStateCell)that);
    return false;
  }

  public boolean equals(BuildJobStateCell that) {
    if (that == null)
      return false;

    boolean this_present_nameHint = true && this.isSetNameHint();
    boolean that_present_nameHint = true && that.isSetNameHint();
    if (this_present_nameHint || that_present_nameHint) {
      if (!(this_present_nameHint && that_present_nameHint))
        return false;
      if (!this.nameHint.equals(that.nameHint))
        return false;
    }

    boolean this_present_config = true && this.isSetConfig();
    boolean that_present_config = true && that.isSetConfig();
    if (this_present_config || that_present_config) {
      if (!(this_present_config && that_present_config))
        return false;
      if (!this.config.equals(that.config))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_nameHint = true && (isSetNameHint());
    list.add(present_nameHint);
    if (present_nameHint)
      list.add(nameHint);

    boolean present_config = true && (isSetConfig());
    list.add(present_config);
    if (present_config)
      list.add(config);

    return list.hashCode();
  }

  @Override
  public int compareTo(BuildJobStateCell other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetNameHint()).compareTo(other.isSetNameHint());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNameHint()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nameHint, other.nameHint);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetConfig()).compareTo(other.isSetConfig());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetConfig()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.config, other.config);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BuildJobStateCell(");
    boolean first = true;

    if (isSetNameHint()) {
      sb.append("nameHint:");
      if (this.nameHint == null) {
        sb.append("null");
      } else {
        sb.append(this.nameHint);
      }
      first = false;
    }
    if (isSetConfig()) {
      if (!first) sb.append(", ");
      sb.append("config:");
      if (this.config == null) {
        sb.append("null");
      } else {
        sb.append(this.config);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (config != null) {
      config.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BuildJobStateCellStandardSchemeFactory implements SchemeFactory {
    public BuildJobStateCellStandardScheme getScheme() {
      return new BuildJobStateCellStandardScheme();
    }
  }

  private static class BuildJobStateCellStandardScheme extends StandardScheme<BuildJobStateCell> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BuildJobStateCell struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME_HINT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.nameHint = iprot.readString();
              struct.setNameHintIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CONFIG
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.config = new BuildJobStateBuckConfig();
              struct.config.read(iprot);
              struct.setConfigIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, BuildJobStateCell struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.nameHint != null) {
        if (struct.isSetNameHint()) {
          oprot.writeFieldBegin(NAME_HINT_FIELD_DESC);
          oprot.writeString(struct.nameHint);
          oprot.writeFieldEnd();
        }
      }
      if (struct.config != null) {
        if (struct.isSetConfig()) {
          oprot.writeFieldBegin(CONFIG_FIELD_DESC);
          struct.config.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BuildJobStateCellTupleSchemeFactory implements SchemeFactory {
    public BuildJobStateCellTupleScheme getScheme() {
      return new BuildJobStateCellTupleScheme();
    }
  }

  private static class BuildJobStateCellTupleScheme extends TupleScheme<BuildJobStateCell> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BuildJobStateCell struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetNameHint()) {
        optionals.set(0);
      }
      if (struct.isSetConfig()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetNameHint()) {
        oprot.writeString(struct.nameHint);
      }
      if (struct.isSetConfig()) {
        struct.config.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BuildJobStateCell struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.nameHint = iprot.readString();
        struct.setNameHintIsSet(true);
      }
      if (incoming.get(1)) {
        struct.config = new BuildJobStateBuckConfig();
        struct.config.read(iprot);
        struct.setConfigIsSet(true);
      }
    }
  }

}

