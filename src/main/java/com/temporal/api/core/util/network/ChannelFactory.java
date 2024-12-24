package com.temporal.api.core.util.network;

import com.temporal.api.core.engine.io.IOHelper;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.EventNetworkChannel;
import net.minecraftforge.network.SimpleChannel;

public class ChannelFactory {
    public static SimpleChannel createSimple(int protocolVersion) {
        return ChannelBuilder.named(IOHelper.createResourceLocation("main"))
                .networkProtocolVersion(protocolVersion)
                .simpleChannel();
    }

    public static EventNetworkChannel createEvent(int protocolVersion) {
        return ChannelBuilder.named(IOHelper.createResourceLocation("main"))
                .networkProtocolVersion(protocolVersion)
                .eventNetworkChannel();
    }
}
