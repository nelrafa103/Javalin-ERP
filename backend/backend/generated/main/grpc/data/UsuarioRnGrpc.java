package data;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: data.proto")
public final class UsuarioRnGrpc {

  private UsuarioRnGrpc() {}

  public static final String SERVICE_NAME = "data.UsuarioRn";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<data.Data.UsuarioRequest,
      data.Data.UsuarioInteface> getGetUsuarioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUsuario",
      requestType = data.Data.UsuarioRequest.class,
      responseType = data.Data.UsuarioInteface.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<data.Data.UsuarioRequest,
      data.Data.UsuarioInteface> getGetUsuarioMethod() {
    io.grpc.MethodDescriptor<data.Data.UsuarioRequest, data.Data.UsuarioInteface> getGetUsuarioMethod;
    if ((getGetUsuarioMethod = UsuarioRnGrpc.getGetUsuarioMethod) == null) {
      synchronized (UsuarioRnGrpc.class) {
        if ((getGetUsuarioMethod = UsuarioRnGrpc.getGetUsuarioMethod) == null) {
          UsuarioRnGrpc.getGetUsuarioMethod = getGetUsuarioMethod =
              io.grpc.MethodDescriptor.<data.Data.UsuarioRequest, data.Data.UsuarioInteface>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUsuario"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.UsuarioRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.UsuarioInteface.getDefaultInstance()))
              .setSchemaDescriptor(new UsuarioRnMethodDescriptorSupplier("getUsuario"))
              .build();
        }
      }
    }
    return getGetUsuarioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<data.Data.UsuarioLogin,
      data.Data.UsuarioInteface> getGetUsuarioLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUsuarioLogin",
      requestType = data.Data.UsuarioLogin.class,
      responseType = data.Data.UsuarioInteface.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<data.Data.UsuarioLogin,
      data.Data.UsuarioInteface> getGetUsuarioLoginMethod() {
    io.grpc.MethodDescriptor<data.Data.UsuarioLogin, data.Data.UsuarioInteface> getGetUsuarioLoginMethod;
    if ((getGetUsuarioLoginMethod = UsuarioRnGrpc.getGetUsuarioLoginMethod) == null) {
      synchronized (UsuarioRnGrpc.class) {
        if ((getGetUsuarioLoginMethod = UsuarioRnGrpc.getGetUsuarioLoginMethod) == null) {
          UsuarioRnGrpc.getGetUsuarioLoginMethod = getGetUsuarioLoginMethod =
              io.grpc.MethodDescriptor.<data.Data.UsuarioLogin, data.Data.UsuarioInteface>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUsuarioLogin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.UsuarioLogin.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.UsuarioInteface.getDefaultInstance()))
              .setSchemaDescriptor(new UsuarioRnMethodDescriptorSupplier("getUsuarioLogin"))
              .build();
        }
      }
    }
    return getGetUsuarioLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<data.Data.UsuarioInteface,
      data.Data.UsuarioInteface> getInsertUsuarioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertUsuario",
      requestType = data.Data.UsuarioInteface.class,
      responseType = data.Data.UsuarioInteface.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<data.Data.UsuarioInteface,
      data.Data.UsuarioInteface> getInsertUsuarioMethod() {
    io.grpc.MethodDescriptor<data.Data.UsuarioInteface, data.Data.UsuarioInteface> getInsertUsuarioMethod;
    if ((getInsertUsuarioMethod = UsuarioRnGrpc.getInsertUsuarioMethod) == null) {
      synchronized (UsuarioRnGrpc.class) {
        if ((getInsertUsuarioMethod = UsuarioRnGrpc.getInsertUsuarioMethod) == null) {
          UsuarioRnGrpc.getInsertUsuarioMethod = getInsertUsuarioMethod =
              io.grpc.MethodDescriptor.<data.Data.UsuarioInteface, data.Data.UsuarioInteface>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertUsuario"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.UsuarioInteface.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.UsuarioInteface.getDefaultInstance()))
              .setSchemaDescriptor(new UsuarioRnMethodDescriptorSupplier("insertUsuario"))
              .build();
        }
      }
    }
    return getInsertUsuarioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<data.Data.UsuarioInteface,
      data.Data.UsuarioInteface> getUpdateUsuarioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateUsuario",
      requestType = data.Data.UsuarioInteface.class,
      responseType = data.Data.UsuarioInteface.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<data.Data.UsuarioInteface,
      data.Data.UsuarioInteface> getUpdateUsuarioMethod() {
    io.grpc.MethodDescriptor<data.Data.UsuarioInteface, data.Data.UsuarioInteface> getUpdateUsuarioMethod;
    if ((getUpdateUsuarioMethod = UsuarioRnGrpc.getUpdateUsuarioMethod) == null) {
      synchronized (UsuarioRnGrpc.class) {
        if ((getUpdateUsuarioMethod = UsuarioRnGrpc.getUpdateUsuarioMethod) == null) {
          UsuarioRnGrpc.getUpdateUsuarioMethod = getUpdateUsuarioMethod =
              io.grpc.MethodDescriptor.<data.Data.UsuarioInteface, data.Data.UsuarioInteface>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateUsuario"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.UsuarioInteface.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.UsuarioInteface.getDefaultInstance()))
              .setSchemaDescriptor(new UsuarioRnMethodDescriptorSupplier("updateUsuario"))
              .build();
        }
      }
    }
    return getUpdateUsuarioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<data.Data.UsuarioRequest,
      data.Data.UsuarioDelete> getDeleteUsuarioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteUsuario",
      requestType = data.Data.UsuarioRequest.class,
      responseType = data.Data.UsuarioDelete.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<data.Data.UsuarioRequest,
      data.Data.UsuarioDelete> getDeleteUsuarioMethod() {
    io.grpc.MethodDescriptor<data.Data.UsuarioRequest, data.Data.UsuarioDelete> getDeleteUsuarioMethod;
    if ((getDeleteUsuarioMethod = UsuarioRnGrpc.getDeleteUsuarioMethod) == null) {
      synchronized (UsuarioRnGrpc.class) {
        if ((getDeleteUsuarioMethod = UsuarioRnGrpc.getDeleteUsuarioMethod) == null) {
          UsuarioRnGrpc.getDeleteUsuarioMethod = getDeleteUsuarioMethod =
              io.grpc.MethodDescriptor.<data.Data.UsuarioRequest, data.Data.UsuarioDelete>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteUsuario"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.UsuarioRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.UsuarioDelete.getDefaultInstance()))
              .setSchemaDescriptor(new UsuarioRnMethodDescriptorSupplier("deleteUsuario"))
              .build();
        }
      }
    }
    return getDeleteUsuarioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<data.Data.Empty,
      data.Data.ListaUsuario> getListUsuarioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listUsuario",
      requestType = data.Data.Empty.class,
      responseType = data.Data.ListaUsuario.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<data.Data.Empty,
      data.Data.ListaUsuario> getListUsuarioMethod() {
    io.grpc.MethodDescriptor<data.Data.Empty, data.Data.ListaUsuario> getListUsuarioMethod;
    if ((getListUsuarioMethod = UsuarioRnGrpc.getListUsuarioMethod) == null) {
      synchronized (UsuarioRnGrpc.class) {
        if ((getListUsuarioMethod = UsuarioRnGrpc.getListUsuarioMethod) == null) {
          UsuarioRnGrpc.getListUsuarioMethod = getListUsuarioMethod =
              io.grpc.MethodDescriptor.<data.Data.Empty, data.Data.ListaUsuario>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listUsuario"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  data.Data.ListaUsuario.getDefaultInstance()))
              .setSchemaDescriptor(new UsuarioRnMethodDescriptorSupplier("listUsuario"))
              .build();
        }
      }
    }
    return getListUsuarioMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UsuarioRnStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UsuarioRnStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UsuarioRnStub>() {
        @java.lang.Override
        public UsuarioRnStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UsuarioRnStub(channel, callOptions);
        }
      };
    return UsuarioRnStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UsuarioRnBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UsuarioRnBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UsuarioRnBlockingStub>() {
        @java.lang.Override
        public UsuarioRnBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UsuarioRnBlockingStub(channel, callOptions);
        }
      };
    return UsuarioRnBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UsuarioRnFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UsuarioRnFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UsuarioRnFutureStub>() {
        @java.lang.Override
        public UsuarioRnFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UsuarioRnFutureStub(channel, callOptions);
        }
      };
    return UsuarioRnFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UsuarioRnImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUsuario(data.Data.UsuarioRequest request,
        io.grpc.stub.StreamObserver<data.Data.UsuarioInteface> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUsuarioMethod(), responseObserver);
    }

    /**
     */
    public void getUsuarioLogin(data.Data.UsuarioLogin request,
        io.grpc.stub.StreamObserver<data.Data.UsuarioInteface> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUsuarioLoginMethod(), responseObserver);
    }

    /**
     */
    public void insertUsuario(data.Data.UsuarioInteface request,
        io.grpc.stub.StreamObserver<data.Data.UsuarioInteface> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInsertUsuarioMethod(), responseObserver);
    }

    /**
     */
    public void updateUsuario(data.Data.UsuarioInteface request,
        io.grpc.stub.StreamObserver<data.Data.UsuarioInteface> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUsuarioMethod(), responseObserver);
    }

    /**
     */
    public void deleteUsuario(data.Data.UsuarioRequest request,
        io.grpc.stub.StreamObserver<data.Data.UsuarioDelete> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUsuarioMethod(), responseObserver);
    }

    /**
     */
    public void listUsuario(data.Data.Empty request,
        io.grpc.stub.StreamObserver<data.Data.ListaUsuario> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUsuarioMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUsuarioMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                data.Data.UsuarioRequest,
                data.Data.UsuarioInteface>(
                  this, METHODID_GET_USUARIO)))
          .addMethod(
            getGetUsuarioLoginMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                data.Data.UsuarioLogin,
                data.Data.UsuarioInteface>(
                  this, METHODID_GET_USUARIO_LOGIN)))
          .addMethod(
            getInsertUsuarioMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                data.Data.UsuarioInteface,
                data.Data.UsuarioInteface>(
                  this, METHODID_INSERT_USUARIO)))
          .addMethod(
            getUpdateUsuarioMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                data.Data.UsuarioInteface,
                data.Data.UsuarioInteface>(
                  this, METHODID_UPDATE_USUARIO)))
          .addMethod(
            getDeleteUsuarioMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                data.Data.UsuarioRequest,
                data.Data.UsuarioDelete>(
                  this, METHODID_DELETE_USUARIO)))
          .addMethod(
            getListUsuarioMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                data.Data.Empty,
                data.Data.ListaUsuario>(
                  this, METHODID_LIST_USUARIO)))
          .build();
    }
  }

  /**
   */
  public static final class UsuarioRnStub extends io.grpc.stub.AbstractAsyncStub<UsuarioRnStub> {
    private UsuarioRnStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsuarioRnStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UsuarioRnStub(channel, callOptions);
    }

    /**
     */
    public void getUsuario(data.Data.UsuarioRequest request,
        io.grpc.stub.StreamObserver<data.Data.UsuarioInteface> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUsuarioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUsuarioLogin(data.Data.UsuarioLogin request,
        io.grpc.stub.StreamObserver<data.Data.UsuarioInteface> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUsuarioLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertUsuario(data.Data.UsuarioInteface request,
        io.grpc.stub.StreamObserver<data.Data.UsuarioInteface> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertUsuarioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUsuario(data.Data.UsuarioInteface request,
        io.grpc.stub.StreamObserver<data.Data.UsuarioInteface> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUsuarioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUsuario(data.Data.UsuarioRequest request,
        io.grpc.stub.StreamObserver<data.Data.UsuarioDelete> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUsuarioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listUsuario(data.Data.Empty request,
        io.grpc.stub.StreamObserver<data.Data.ListaUsuario> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUsuarioMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UsuarioRnBlockingStub extends io.grpc.stub.AbstractBlockingStub<UsuarioRnBlockingStub> {
    private UsuarioRnBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsuarioRnBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UsuarioRnBlockingStub(channel, callOptions);
    }

    /**
     */
    public data.Data.UsuarioInteface getUsuario(data.Data.UsuarioRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUsuarioMethod(), getCallOptions(), request);
    }

    /**
     */
    public data.Data.UsuarioInteface getUsuarioLogin(data.Data.UsuarioLogin request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUsuarioLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public data.Data.UsuarioInteface insertUsuario(data.Data.UsuarioInteface request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertUsuarioMethod(), getCallOptions(), request);
    }

    /**
     */
    public data.Data.UsuarioInteface updateUsuario(data.Data.UsuarioInteface request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUsuarioMethod(), getCallOptions(), request);
    }

    /**
     */
    public data.Data.UsuarioDelete deleteUsuario(data.Data.UsuarioRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUsuarioMethod(), getCallOptions(), request);
    }

    /**
     */
    public data.Data.ListaUsuario listUsuario(data.Data.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUsuarioMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UsuarioRnFutureStub extends io.grpc.stub.AbstractFutureStub<UsuarioRnFutureStub> {
    private UsuarioRnFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsuarioRnFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UsuarioRnFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<data.Data.UsuarioInteface> getUsuario(
        data.Data.UsuarioRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUsuarioMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<data.Data.UsuarioInteface> getUsuarioLogin(
        data.Data.UsuarioLogin request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUsuarioLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<data.Data.UsuarioInteface> insertUsuario(
        data.Data.UsuarioInteface request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertUsuarioMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<data.Data.UsuarioInteface> updateUsuario(
        data.Data.UsuarioInteface request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUsuarioMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<data.Data.UsuarioDelete> deleteUsuario(
        data.Data.UsuarioRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUsuarioMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<data.Data.ListaUsuario> listUsuario(
        data.Data.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUsuarioMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USUARIO = 0;
  private static final int METHODID_GET_USUARIO_LOGIN = 1;
  private static final int METHODID_INSERT_USUARIO = 2;
  private static final int METHODID_UPDATE_USUARIO = 3;
  private static final int METHODID_DELETE_USUARIO = 4;
  private static final int METHODID_LIST_USUARIO = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UsuarioRnImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UsuarioRnImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USUARIO:
          serviceImpl.getUsuario((data.Data.UsuarioRequest) request,
              (io.grpc.stub.StreamObserver<data.Data.UsuarioInteface>) responseObserver);
          break;
        case METHODID_GET_USUARIO_LOGIN:
          serviceImpl.getUsuarioLogin((data.Data.UsuarioLogin) request,
              (io.grpc.stub.StreamObserver<data.Data.UsuarioInteface>) responseObserver);
          break;
        case METHODID_INSERT_USUARIO:
          serviceImpl.insertUsuario((data.Data.UsuarioInteface) request,
              (io.grpc.stub.StreamObserver<data.Data.UsuarioInteface>) responseObserver);
          break;
        case METHODID_UPDATE_USUARIO:
          serviceImpl.updateUsuario((data.Data.UsuarioInteface) request,
              (io.grpc.stub.StreamObserver<data.Data.UsuarioInteface>) responseObserver);
          break;
        case METHODID_DELETE_USUARIO:
          serviceImpl.deleteUsuario((data.Data.UsuarioRequest) request,
              (io.grpc.stub.StreamObserver<data.Data.UsuarioDelete>) responseObserver);
          break;
        case METHODID_LIST_USUARIO:
          serviceImpl.listUsuario((data.Data.Empty) request,
              (io.grpc.stub.StreamObserver<data.Data.ListaUsuario>) responseObserver);
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

  private static abstract class UsuarioRnBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UsuarioRnBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return data.Data.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UsuarioRn");
    }
  }

  private static final class UsuarioRnFileDescriptorSupplier
      extends UsuarioRnBaseDescriptorSupplier {
    UsuarioRnFileDescriptorSupplier() {}
  }

  private static final class UsuarioRnMethodDescriptorSupplier
      extends UsuarioRnBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UsuarioRnMethodDescriptorSupplier(String methodName) {
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
      synchronized (UsuarioRnGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UsuarioRnFileDescriptorSupplier())
              .addMethod(getGetUsuarioMethod())
              .addMethod(getGetUsuarioLoginMethod())
              .addMethod(getInsertUsuarioMethod())
              .addMethod(getUpdateUsuarioMethod())
              .addMethod(getDeleteUsuarioMethod())
              .addMethod(getListUsuarioMethod())
              .build();
        }
      }
    }
    return result;
  }
}
