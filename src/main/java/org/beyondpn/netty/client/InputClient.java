package org.beyondpn.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-22 下午11:14
 */
public class InputClient {

    public static void main(String... args) throws Exception {
        Bootstrap bootstrap = new Bootstrap();
        ChannelFuture future = bootstrap.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new InputHandler())
                .option(ChannelOption.TCP_NODELAY, true)
                .connect("127.0.0.1", 8888)
                .sync();
        future.channel().closeFuture().sync();
    }
}
