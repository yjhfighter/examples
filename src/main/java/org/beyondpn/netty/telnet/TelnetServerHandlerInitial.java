package org.beyondpn.netty.telnet;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-31 下午5:46
 */
public class TelnetServerHandlerInitial extends ChannelInitializer<Channel> {

    private static final StringDecoder DECODER = new StringDecoder();
    private static final StringEncoder ENCODER = new StringEncoder();
    private static final TelnetServerHandler SERVER_HANDLER = new TelnetServerHandler();

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        p.addLast("framer",new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        p.addLast("decoder", DECODER);
        p.addLast("encoder", ENCODER);
        p.addLast("handler", SERVER_HANDLER);
    }
}
