//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.9
//
// <auto-generated>
//
// Generated from file `Printer.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Demo;

public interface CallbackSenderPrx extends com.zeroc.Ice.ObjectPrx
{
    default void messageToHostname(CallbackReceiverPrx proxy, String hostname, String msg)
    {
        messageToHostname(proxy, hostname, msg, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void messageToHostname(CallbackReceiverPrx proxy, String hostname, String msg, java.util.Map<String, String> context)
    {
        _iceI_messageToHostnameAsync(proxy, hostname, msg, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> messageToHostnameAsync(CallbackReceiverPrx proxy, String hostname, String msg)
    {
        return _iceI_messageToHostnameAsync(proxy, hostname, msg, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> messageToHostnameAsync(CallbackReceiverPrx proxy, String hostname, String msg, java.util.Map<String, String> context)
    {
        return _iceI_messageToHostnameAsync(proxy, hostname, msg, context, false);
    }

    /**
     * @hidden
     * @param iceP_proxy -
     * @param iceP_hostname -
     * @param iceP_msg -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_messageToHostnameAsync(CallbackReceiverPrx iceP_proxy, String iceP_hostname, String iceP_msg, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "messageToHostname", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_proxy);
                     ostr.writeString(iceP_hostname);
                     ostr.writeString(iceP_msg);
                 }, null);
        return f;
    }

    default void initiateCallback(String hostname, CallbackReceiverPrx proxy)
    {
        initiateCallback(hostname, proxy, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void initiateCallback(String hostname, CallbackReceiverPrx proxy, java.util.Map<String, String> context)
    {
        _iceI_initiateCallbackAsync(hostname, proxy, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> initiateCallbackAsync(String hostname, CallbackReceiverPrx proxy)
    {
        return _iceI_initiateCallbackAsync(hostname, proxy, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> initiateCallbackAsync(String hostname, CallbackReceiverPrx proxy, java.util.Map<String, String> context)
    {
        return _iceI_initiateCallbackAsync(hostname, proxy, context, false);
    }

    /**
     * @hidden
     * @param iceP_hostname -
     * @param iceP_proxy -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_initiateCallbackAsync(String iceP_hostname, CallbackReceiverPrx iceP_proxy, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "initiateCallback", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeString(iceP_hostname);
                     ostr.writeProxy(iceP_proxy);
                 }, null);
        return f;
    }

    default void shutdown()
    {
        shutdown(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void shutdown(java.util.Map<String, String> context)
    {
        _iceI_shutdownAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> shutdownAsync()
    {
        return _iceI_shutdownAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> shutdownAsync(java.util.Map<String, String> context)
    {
        return _iceI_shutdownAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_shutdownAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "shutdown", null, sync, null);
        f.invoke(false, context, null, null, null);
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static CallbackSenderPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), CallbackSenderPrx.class, _CallbackSenderPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static CallbackSenderPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), CallbackSenderPrx.class, _CallbackSenderPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static CallbackSenderPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), CallbackSenderPrx.class, _CallbackSenderPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static CallbackSenderPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), CallbackSenderPrx.class, _CallbackSenderPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static CallbackSenderPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, CallbackSenderPrx.class, _CallbackSenderPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static CallbackSenderPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, CallbackSenderPrx.class, _CallbackSenderPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default CallbackSenderPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (CallbackSenderPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default CallbackSenderPrx ice_adapterId(String newAdapterId)
    {
        return (CallbackSenderPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default CallbackSenderPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (CallbackSenderPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default CallbackSenderPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (CallbackSenderPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default CallbackSenderPrx ice_invocationTimeout(int newTimeout)
    {
        return (CallbackSenderPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default CallbackSenderPrx ice_connectionCached(boolean newCache)
    {
        return (CallbackSenderPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default CallbackSenderPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (CallbackSenderPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default CallbackSenderPrx ice_secure(boolean b)
    {
        return (CallbackSenderPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default CallbackSenderPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (CallbackSenderPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default CallbackSenderPrx ice_preferSecure(boolean b)
    {
        return (CallbackSenderPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default CallbackSenderPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (CallbackSenderPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default CallbackSenderPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (CallbackSenderPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default CallbackSenderPrx ice_collocationOptimized(boolean b)
    {
        return (CallbackSenderPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default CallbackSenderPrx ice_twoway()
    {
        return (CallbackSenderPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default CallbackSenderPrx ice_oneway()
    {
        return (CallbackSenderPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default CallbackSenderPrx ice_batchOneway()
    {
        return (CallbackSenderPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default CallbackSenderPrx ice_datagram()
    {
        return (CallbackSenderPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default CallbackSenderPrx ice_batchDatagram()
    {
        return (CallbackSenderPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default CallbackSenderPrx ice_compress(boolean co)
    {
        return (CallbackSenderPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default CallbackSenderPrx ice_timeout(int t)
    {
        return (CallbackSenderPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default CallbackSenderPrx ice_connectionId(String connectionId)
    {
        return (CallbackSenderPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default CallbackSenderPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (CallbackSenderPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::Demo::CallbackSender";
    }
}
