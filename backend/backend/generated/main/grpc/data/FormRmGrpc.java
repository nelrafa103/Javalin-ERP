package data;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: data.proto")
public final class FormRmGrpc {

  private FormRmGrpc() {}

  public static final String SERVICE_NAME = "data.FormRm";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<data.Data.FormRequest,
      data.Data.FormInterface> getGetFormMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getForm",
      requestType = data.Data.FormRequest.class,
      responseType = data.Data.FormInterface.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<data.Data.FormRequest,
      data.Data.FormInterface> getGetFormMethod() {
    io.grpc.MethodDescriptor<data.Data.FormRequest, data.Data.FormInterface> getGetFormMethod;
    if ((getGetFormMethod = FormRmGrpc.getGetFormMethod) == null) {
      synchronized (FormRmGrpc.class) {
        if ((getGetFormMethod = FormRmGrpc.getGetFormMethod) == null) {
          FormRmGrpc.getGetFormMethod = getGetFormMethod =
              io.grpc.MethodDescriptor.<data.Data.FormRequest, data.Data.FormInterface>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getForm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.FormRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.FormInterface.getDefaultInstance()))
              .setSchemaDescriptor(new FormRmMethodDescriptorSupplier("getForm"))
              .build();
        }
      }
    }
    return getGetFormMethod;
  }

  private static volatile io.grpc.MethodDescriptor<data.Data.FormInterface,
      data.Data.FormInterface> getInsertFormMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertForm",
      requestType = data.Data.FormInterface.class,
      responseType = data.Data.FormInterface.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<data.Data.FormInterface,
      data.Data.FormInterface> getInsertFormMethod() {
    io.grpc.MethodDescriptor<data.Data.FormInterface, data.Data.FormInterface> getInsertFormMethod;
    if ((getInsertFormMethod = FormRmGrpc.getInsertFormMethod) == null) {
      synchronized (FormRmGrpc.class) {
        if ((getInsertFormMethod = FormRmGrpc.getInsertFormMethod) == null) {
          FormRmGrpc.getInsertFormMethod = getInsertFormMethod =
              io.grpc.MethodDescriptor.<data.Data.FormInterface, data.Data.FormInterface>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertForm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.FormInterface.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.FormInterface.getDefaultInstance()))
              .setSchemaDescriptor(new FormRmMethodDescriptorSupplier("insertForm"))
              .build();
        }
      }
    }
    return getInsertFormMethod;
  }

  private static volatile io.grpc.MethodDescriptor<data.Data.FormInterface,
      data.Data.FormInterface> getUpdateFormMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateForm",
      requestType = data.Data.FormInterface.class,
      responseType = data.Data.FormInterface.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<data.Data.FormInterface,
      data.Data.FormInterface> getUpdateFormMethod() {
    io.grpc.MethodDescriptor<data.Data.FormInterface, data.Data.FormInterface> getUpdateFormMethod;
    if ((getUpdateFormMethod = FormRmGrpc.getUpdateFormMethod) == null) {
      synchronized (FormRmGrpc.class) {
        if ((getUpdateFormMethod = FormRmGrpc.getUpdateFormMethod) == null) {
          FormRmGrpc.getUpdateFormMethod = getUpdateFormMethod =
              io.grpc.MethodDescriptor.<data.Data.FormInterface, data.Data.FormInterface>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateForm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.FormInterface.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.FormInterface.getDefaultInstance()))
              .setSchemaDescriptor(new FormRmMethodDescriptorSupplier("updateForm"))
              .build();
        }
      }
    }
    return getUpdateFormMethod;
  }

  private static volatile io.grpc.MethodDescriptor<data.Data.FormRequest,
      data.Data.FormDelete> getDeleteFormMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteForm",
      requestType = data.Data.FormRequest.class,
      responseType = data.Data.FormDelete.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<data.Data.FormRequest,
      data.Data.FormDelete> getDeleteFormMethod() {
    io.grpc.MethodDescriptor<data.Data.FormRequest, data.Data.FormDelete> getDeleteFormMethod;
    if ((getDeleteFormMethod = FormRmGrpc.getDeleteFormMethod) == null) {
      synchronized (FormRmGrpc.class) {
        if ((getDeleteFormMethod = FormRmGrpc.getDeleteFormMethod) == null) {
          FormRmGrpc.getDeleteFormMethod = getDeleteFormMethod =
              io.grpc.MethodDescriptor.<data.Data.FormRequest, data.Data.FormDelete>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteForm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.FormRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.FormDelete.getDefaultInstance()))
              .setSchemaDescriptor(new FormRmMethodDescriptorSupplier("deleteForm"))
              .build();
        }
      }
    }
    return getDeleteFormMethod;
  }

  private static volatile io.grpc.MethodDescriptor<data.Data.Empty,
      data.Data.ListaForm> getListFormMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listForm",
      requestType = data.Data.Empty.class,
      responseType = data.Data.ListaForm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<data.Data.Empty,
      data.Data.ListaForm> getListFormMethod() {
    io.grpc.MethodDescriptor<data.Data.Empty, data.Data.ListaForm> getListFormMethod;
    if ((getListFormMethod = FormRmGrpc.getListFormMethod) == null) {
      synchronized (FormRmGrpc.class) {
        if ((getListFormMethod = FormRmGrpc.getListFormMethod) == null) {
          FormRmGrpc.getListFormMethod = getListFormMethod =
              io.grpc.MethodDescriptor.<data.Data.Empty, data.Data.ListaForm>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listForm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.ListaForm.getDefaultInstance()))
              .setSchemaDescriptor(new FormRmMethodDescriptorSupplier("listForm"))
              .build();
        }
      }
    }
    return getListFormMethod;
  }

  private static volatile io.grpc.MethodDescriptor<data.Data.FormRequest,
      data.Data.ListaForm> getListFormUsuarioIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listFormUsuarioId",
      requestType = data.Data.FormRequest.class,
      responseType = data.Data.ListaForm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<data.Data.FormRequest,
      data.Data.ListaForm> getListFormUsuarioIdMethod() {
    io.grpc.MethodDescriptor<data.Data.FormRequest, data.Data.ListaForm> getListFormUsuarioIdMethod;
    if ((getListFormUsuarioIdMethod = FormRmGrpc.getListFormUsuarioIdMethod) == null) {
      synchronized (FormRmGrpc.class) {
        if ((getListFormUsuarioIdMethod = FormRmGrpc.getListFormUsuarioIdMethod) == null) {
          FormRmGrpc.getListFormUsuarioIdMethod = getListFormUsuarioIdMethod =
              io.grpc.MethodDescriptor.<data.Data.FormRequest, data.Data.ListaForm>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listFormUsuarioId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.FormRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.ListaForm.getDefaultInstance()))
              .setSchemaDescriptor(new FormRmMethodDescriptorSupplier("listFormUsuarioId"))
              .build();
        }
      }
    }
    return getListFormUsuarioIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<data.Data.FormRequest,
      data.Data.ListaForm> getListFormNombreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listFormNombre",
      requestType = data.Data.FormRequest.class,
      responseType = data.Data.ListaForm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<data.Data.FormRequest,
      data.Data.ListaForm> getListFormNombreMethod() {
    io.grpc.MethodDescriptor<data.Data.FormRequest, data.Data.ListaForm> getListFormNombreMethod;
    if ((getListFormNombreMethod = FormRmGrpc.getListFormNombreMethod) == null) {
      synchronized (FormRmGrpc.class) {
        if ((getListFormNombreMethod = FormRmGrpc.getListFormNombreMethod) == null) {
          FormRmGrpc.getListFormNombreMethod = getListFormNombreMethod =
              io.grpc.MethodDescriptor.<data.Data.FormRequest, data.Data.ListaForm>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listFormNombre"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.FormRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.ListaForm.getDefaultInstance()))
              .setSchemaDescriptor(new FormRmMethodDescriptorSupplier("listFormNombre"))
              .build();
        }
      }
    }
    return getListFormNombreMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FormRmStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FormRmStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FormRmStub>() {
        @java.lang.Override
        public FormRmStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FormRmStub(channel, callOptions);
        }
      };
    return FormRmStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FormRmBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FormRmBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FormRmBlockingStub>() {
        @java.lang.Override
        public FormRmBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FormRmBlockingStub(channel, callOptions);
        }
      };
    return FormRmBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FormRmFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FormRmFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FormRmFutureStub>() {
        @java.lang.Override
        public FormRmFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FormRmFutureStub(channel, callOptions);
        }
      };
    return FormRmFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FormRmImplBase implements io.grpc.BindableService {

    /**
     */
    public void getForm(data.Data.FormRequest request,
        io.grpc.stub.StreamObserver<data.Data.FormInterface> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFormMethod(), responseObserver);
    }

    /**
     */
    public void insertForm(data.Data.FormInterface request,
        io.grpc.stub.StreamObserver<data.Data.FormInterface> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInsertFormMethod(), responseObserver);
    }

    /**
     */
    public void updateForm(data.Data.FormInterface request,
        io.grpc.stub.StreamObserver<data.Data.FormInterface> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateFormMethod(), responseObserver);
    }

    /**
     */
    public void deleteForm(data.Data.FormRequest request,
        io.grpc.stub.StreamObserver<data.Data.FormDelete> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFormMethod(), responseObserver);
    }

    /**
     */
    public void listForm(data.Data.Empty request,
        io.grpc.stub.StreamObserver<data.Data.ListaForm> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFormMethod(), responseObserver);
    }

    /**
     */
    public void listFormUsuarioId(data.Data.FormRequest request,
        io.grpc.stub.StreamObserver<data.Data.ListaForm> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFormUsuarioIdMethod(), responseObserver);
    }

    /**
     */
    public void listFormNombre(data.Data.FormRequest request,
        io.grpc.stub.StreamObserver<data.Data.ListaForm> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFormNombreMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFormMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                data.Data.FormRequest,
                data.Data.FormInterface>(
                  this, METHODID_GET_FORM)))
          .addMethod(
            getInsertFormMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                data.Data.FormInterface,
                data.Data.FormInterface>(
                  this, METHODID_INSERT_FORM)))
          .addMethod(
            getUpdateFormMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                data.Data.FormInterface,
                data.Data.FormInterface>(
                  this, METHODID_UPDATE_FORM)))
          .addMethod(
            getDeleteFormMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                data.Data.FormRequest,
                data.Data.FormDelete>(
                  this, METHODID_DELETE_FORM)))
          .addMethod(
            getListFormMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                data.Data.Empty,
                data.Data.ListaForm>(
                  this, METHODID_LIST_FORM)))
          .addMethod(
            getListFormUsuarioIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                data.Data.FormRequest,
                data.Data.ListaForm>(
                  this, METHODID_LIST_FORM_USUARIO_ID)))
          .addMethod(
            getListFormNombreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                data.Data.FormRequest,
                data.Data.ListaForm>(
                  this, METHODID_LIST_FORM_NOMBRE)))
          .build();
    }
  }

  /**
   */
  public static final class FormRmStub extends io.grpc.stub.AbstractAsyncStub<FormRmStub> {
    private FormRmStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FormRmStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FormRmStub(channel, callOptions);
    }

    /**
     */
    public void getForm(data.Data.FormRequest request,
        io.grpc.stub.StreamObserver<data.Data.FormInterface> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFormMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertForm(data.Data.FormInterface request,
        io.grpc.stub.StreamObserver<data.Data.FormInterface> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertFormMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateForm(data.Data.FormInterface request,
        io.grpc.stub.StreamObserver<data.Data.FormInterface> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFormMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteForm(data.Data.FormRequest request,
        io.grpc.stub.StreamObserver<data.Data.FormDelete> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFormMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listForm(data.Data.Empty request,
        io.grpc.stub.StreamObserver<data.Data.ListaForm> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFormMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listFormUsuarioId(data.Data.FormRequest request,
        io.grpc.stub.StreamObserver<data.Data.ListaForm> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFormUsuarioIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listFormNombre(data.Data.FormRequest request,
        io.grpc.stub.StreamObserver<data.Data.ListaForm> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFormNombreMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FormRmBlockingStub extends io.grpc.stub.AbstractBlockingStub<FormRmBlockingStub> {
    private FormRmBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FormRmBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FormRmBlockingStub(channel, callOptions);
    }

    /**
     */
    public data.Data.FormInterface getForm(data.Data.FormRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFormMethod(), getCallOptions(), request);
    }

    /**
     */
    public data.Data.FormInterface insertForm(data.Data.FormInterface request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertFormMethod(), getCallOptions(), request);
    }

    /**
     */
    public data.Data.FormInterface updateForm(data.Data.FormInterface request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFormMethod(), getCallOptions(), request);
    }

    /**
     */
    public data.Data.FormDelete deleteForm(data.Data.FormRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFormMethod(), getCallOptions(), request);
    }

    /**
     */
    public data.Data.ListaForm listForm(data.Data.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFormMethod(), getCallOptions(), request);
    }

    /**
     */
    public data.Data.ListaForm listFormUsuarioId(data.Data.FormRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFormUsuarioIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public data.Data.ListaForm listFormNombre(data.Data.FormRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFormNombreMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FormRmFutureStub extends io.grpc.stub.AbstractFutureStub<FormRmFutureStub> {
    private FormRmFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FormRmFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FormRmFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<data.Data.FormInterface> getForm(
        data.Data.FormRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFormMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<data.Data.FormInterface> insertForm(
        data.Data.FormInterface request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertFormMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<data.Data.FormInterface> updateForm(
        data.Data.FormInterface request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFormMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<data.Data.FormDelete> deleteForm(
        data.Data.FormRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFormMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<data.Data.ListaForm> listForm(
        data.Data.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFormMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<data.Data.ListaForm> listFormUsuarioId(
        data.Data.FormRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFormUsuarioIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<data.Data.ListaForm> listFormNombre(
        data.Data.FormRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFormNombreMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FORM = 0;
  private static final int METHODID_INSERT_FORM = 1;
  private static final int METHODID_UPDATE_FORM = 2;
  private static final int METHODID_DELETE_FORM = 3;
  private static final int METHODID_LIST_FORM = 4;
  private static final int METHODID_LIST_FORM_USUARIO_ID = 5;
  private static final int METHODID_LIST_FORM_NOMBRE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FormRmImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FormRmImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FORM:
          serviceImpl.getForm((data.Data.FormRequest) request,
              (io.grpc.stub.StreamObserver<data.Data.FormInterface>) responseObserver);
          break;
        case METHODID_INSERT_FORM:
          serviceImpl.insertForm((data.Data.FormInterface) request,
              (io.grpc.stub.StreamObserver<data.Data.FormInterface>) responseObserver);
          break;
        case METHODID_UPDATE_FORM:
          serviceImpl.updateForm((data.Data.FormInterface) request,
              (io.grpc.stub.StreamObserver<data.Data.FormInterface>) responseObserver);
          break;
        case METHODID_DELETE_FORM:
          serviceImpl.deleteForm((data.Data.FormRequest) request,
              (io.grpc.stub.StreamObserver<data.Data.FormDelete>) responseObserver);
          break;
        case METHODID_LIST_FORM:
          serviceImpl.listForm((data.Data.Empty) request,
              (io.grpc.stub.StreamObserver<data.Data.ListaForm>) responseObserver);
          break;
        case METHODID_LIST_FORM_USUARIO_ID:
          serviceImpl.listFormUsuarioId((data.Data.FormRequest) request,
              (io.grpc.stub.StreamObserver<data.Data.ListaForm>) responseObserver);
          break;
        case METHODID_LIST_FORM_NOMBRE:
          serviceImpl.listFormNombre((data.Data.FormRequest) request,
              (io.grpc.stub.StreamObserver<data.Data.ListaForm>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FormRmBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FormRmBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return data.Data.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FormRm");
    }
  }

  private static final class FormRmFileDescriptorSupplier
      extends FormRmBaseDescriptorSupplier {
    FormRmFileDescriptorSupplier() {}
  }

  private static final class FormRmMethodDescriptorSupplier
      extends FormRmBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FormRmMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FormRmGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FormRmFileDescriptorSupplier())
              .addMethod(getGetFormMethod())
              .addMethod(getInsertFormMethod())
              .addMethod(getUpdateFormMethod())
              .addMethod(getDeleteFormMethod())
              .addMethod(getListFormMethod())
              .addMethod(getListFormUsuarioIdMethod())
              .addMethod(getListFormNombreMethod())
              .build();
        }
      }
    }
    return result;
  }
}
