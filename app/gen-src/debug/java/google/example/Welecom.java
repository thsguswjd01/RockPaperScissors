// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: game.proto

package google.example;

/**
 * Protobuf type {@code google.example.Welecom}
 */
public final class Welecom extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.example.Welecom)
    WelecomOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Welecom.newBuilder() to construct.
  private Welecom(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Welecom() {
    status_ = 0;
    ctype_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Welecom();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Welecom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            int rawValue = input.readEnum();

            status_ = rawValue;
            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            ctype_ = rawValue;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return google.example.Game.internal_static_google_example_Welecom_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return google.example.Game.internal_static_google_example_Welecom_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            google.example.Welecom.class, google.example.Welecom.Builder.class);
  }

  /**
   * Protobuf enum {@code google.example.Welecom.Status}
   */
  public enum Status
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>WAIT = 0;</code>
     */
    WAIT(0),
    /**
     * <code>READY = 1;</code>
     */
    READY(1),
    /**
     * <code>READY_IS_HOST = 2;</code>
     */
    READY_IS_HOST(2),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>WAIT = 0;</code>
     */
    public static final int WAIT_VALUE = 0;
    /**
     * <code>READY = 1;</code>
     */
    public static final int READY_VALUE = 1;
    /**
     * <code>READY_IS_HOST = 2;</code>
     */
    public static final int READY_IS_HOST_VALUE = 2;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Status valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static Status forNumber(int value) {
      switch (value) {
        case 0: return WAIT;
        case 1: return READY;
        case 2: return READY_IS_HOST;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Status>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Status> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Status>() {
            public Status findValueByNumber(int number) {
              return Status.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return google.example.Welecom.getDescriptor().getEnumTypes().get(0);
    }

    private static final Status[] VALUES = values();

    public static Status valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Status(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:google.example.Welecom.Status)
  }

  /**
   * Protobuf enum {@code google.example.Welecom.ClientType}
   */
  public enum ClientType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>HOST = 0;</code>
     */
    HOST(0),
    /**
     * <code>GUEST = 1;</code>
     */
    GUEST(1),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>HOST = 0;</code>
     */
    public static final int HOST_VALUE = 0;
    /**
     * <code>GUEST = 1;</code>
     */
    public static final int GUEST_VALUE = 1;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static ClientType valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static ClientType forNumber(int value) {
      switch (value) {
        case 0: return HOST;
        case 1: return GUEST;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<ClientType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        ClientType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<ClientType>() {
            public ClientType findValueByNumber(int number) {
              return ClientType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return google.example.Welecom.getDescriptor().getEnumTypes().get(1);
    }

    private static final ClientType[] VALUES = values();

    public static ClientType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private ClientType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:google.example.Welecom.ClientType)
  }

  public static final int STATUS_FIELD_NUMBER = 1;
  private int status_;
  /**
   * <code>.google.example.Welecom.Status status = 1;</code>
   * @return The enum numeric value on the wire for status.
   */
  @java.lang.Override public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.google.example.Welecom.Status status = 1;</code>
   * @return The status.
   */
  @java.lang.Override public google.example.Welecom.Status getStatus() {
    @SuppressWarnings("deprecation")
    google.example.Welecom.Status result = google.example.Welecom.Status.valueOf(status_);
    return result == null ? google.example.Welecom.Status.UNRECOGNIZED : result;
  }

  public static final int CTYPE_FIELD_NUMBER = 2;
  private int ctype_;
  /**
   * <code>.google.example.Welecom.ClientType ctype = 2;</code>
   * @return The enum numeric value on the wire for ctype.
   */
  @java.lang.Override public int getCtypeValue() {
    return ctype_;
  }
  /**
   * <code>.google.example.Welecom.ClientType ctype = 2;</code>
   * @return The ctype.
   */
  @java.lang.Override public google.example.Welecom.ClientType getCtype() {
    @SuppressWarnings("deprecation")
    google.example.Welecom.ClientType result = google.example.Welecom.ClientType.valueOf(ctype_);
    return result == null ? google.example.Welecom.ClientType.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (status_ != google.example.Welecom.Status.WAIT.getNumber()) {
      output.writeEnum(1, status_);
    }
    if (ctype_ != google.example.Welecom.ClientType.HOST.getNumber()) {
      output.writeEnum(2, ctype_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (status_ != google.example.Welecom.Status.WAIT.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, status_);
    }
    if (ctype_ != google.example.Welecom.ClientType.HOST.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, ctype_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof google.example.Welecom)) {
      return super.equals(obj);
    }
    google.example.Welecom other = (google.example.Welecom) obj;

    if (status_ != other.status_) return false;
    if (ctype_ != other.ctype_) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    hash = (37 * hash) + CTYPE_FIELD_NUMBER;
    hash = (53 * hash) + ctype_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static google.example.Welecom parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static google.example.Welecom parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static google.example.Welecom parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static google.example.Welecom parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static google.example.Welecom parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static google.example.Welecom parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static google.example.Welecom parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static google.example.Welecom parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static google.example.Welecom parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static google.example.Welecom parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static google.example.Welecom parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static google.example.Welecom parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(google.example.Welecom prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code google.example.Welecom}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.example.Welecom)
      google.example.WelecomOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return google.example.Game.internal_static_google_example_Welecom_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return google.example.Game.internal_static_google_example_Welecom_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              google.example.Welecom.class, google.example.Welecom.Builder.class);
    }

    // Construct using google.example.Welecom.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      status_ = 0;

      ctype_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return google.example.Game.internal_static_google_example_Welecom_descriptor;
    }

    @java.lang.Override
    public google.example.Welecom getDefaultInstanceForType() {
      return google.example.Welecom.getDefaultInstance();
    }

    @java.lang.Override
    public google.example.Welecom build() {
      google.example.Welecom result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public google.example.Welecom buildPartial() {
      google.example.Welecom result = new google.example.Welecom(this);
      result.status_ = status_;
      result.ctype_ = ctype_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof google.example.Welecom) {
        return mergeFrom((google.example.Welecom)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(google.example.Welecom other) {
      if (other == google.example.Welecom.getDefaultInstance()) return this;
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      if (other.ctype_ != 0) {
        setCtypeValue(other.getCtypeValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      google.example.Welecom parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (google.example.Welecom) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int status_ = 0;
    /**
     * <code>.google.example.Welecom.Status status = 1;</code>
     * @return The enum numeric value on the wire for status.
     */
    @java.lang.Override public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.google.example.Welecom.Status status = 1;</code>
     * @param value The enum numeric value on the wire for status to set.
     * @return This builder for chaining.
     */
    public Builder setStatusValue(int value) {
      
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.google.example.Welecom.Status status = 1;</code>
     * @return The status.
     */
    @java.lang.Override
    public google.example.Welecom.Status getStatus() {
      @SuppressWarnings("deprecation")
      google.example.Welecom.Status result = google.example.Welecom.Status.valueOf(status_);
      return result == null ? google.example.Welecom.Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.google.example.Welecom.Status status = 1;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(google.example.Welecom.Status value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.google.example.Welecom.Status status = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }

    private int ctype_ = 0;
    /**
     * <code>.google.example.Welecom.ClientType ctype = 2;</code>
     * @return The enum numeric value on the wire for ctype.
     */
    @java.lang.Override public int getCtypeValue() {
      return ctype_;
    }
    /**
     * <code>.google.example.Welecom.ClientType ctype = 2;</code>
     * @param value The enum numeric value on the wire for ctype to set.
     * @return This builder for chaining.
     */
    public Builder setCtypeValue(int value) {
      
      ctype_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.google.example.Welecom.ClientType ctype = 2;</code>
     * @return The ctype.
     */
    @java.lang.Override
    public google.example.Welecom.ClientType getCtype() {
      @SuppressWarnings("deprecation")
      google.example.Welecom.ClientType result = google.example.Welecom.ClientType.valueOf(ctype_);
      return result == null ? google.example.Welecom.ClientType.UNRECOGNIZED : result;
    }
    /**
     * <code>.google.example.Welecom.ClientType ctype = 2;</code>
     * @param value The ctype to set.
     * @return This builder for chaining.
     */
    public Builder setCtype(google.example.Welecom.ClientType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      ctype_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.google.example.Welecom.ClientType ctype = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearCtype() {
      
      ctype_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:google.example.Welecom)
  }

  // @@protoc_insertion_point(class_scope:google.example.Welecom)
  private static final google.example.Welecom DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new google.example.Welecom();
  }

  public static google.example.Welecom getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Welecom>
      PARSER = new com.google.protobuf.AbstractParser<Welecom>() {
    @java.lang.Override
    public Welecom parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Welecom(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Welecom> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Welecom> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public google.example.Welecom getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

