package com.temporal.api.core.util.network;

import com.temporal.api.core.engine.io.resource.InjectedResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.event.EventNetworkChannel;
import net.minecraftforge.network.simple.SimpleChannel;

public class ChannelFactory {
    public static SimpleChannel createSimple(String protocolVersion) {
        return NetworkRegistry.newSimpleChannel(
                new InjectedResourceLocation("main"),
                () -> protocolVersion,
                protocolVersion::equals,
                protocolVersion::equals
        );
    }

    public static EventNetworkChannel createEvent(String protocolVersion) {
        return NetworkRegistry.newEventChannel(
                new InjectedResourceLocation("main"),
                () -> protocolVersion,
                protocolVersion::equals,
                protocolVersion::equals
        );
    }
}
