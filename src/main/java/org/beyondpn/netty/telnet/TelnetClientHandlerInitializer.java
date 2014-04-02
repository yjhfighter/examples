package org.beyondpn.netty.telnet;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-28 下午4:27
 */
public class TelnetClientHandlerInitializer extends ChannelInitializer<SocketChannel> {

    public static final StringDecoder DECODER = new StringDecoder();
    public static final StringEncoder ENCODER = new StringEncoder();
    private static final TelnetClientHandler CLIENT_HANDLER = new TelnetClientHandler();

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        p.addLast("framer",new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        p.addLast("decoder",DECODER);
        p.addLast("encoder",ENCODER);
        p.addLast("handler",CLIENT_HANDLER);
    }
}
