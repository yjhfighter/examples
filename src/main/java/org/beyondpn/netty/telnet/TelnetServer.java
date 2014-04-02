package org.beyondpn.netty.telnet;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-31 下午5:45
 */
public class TelnetServer {

    private final int port;

    public TelnetServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .childHandler(new TelnetServerClientHandlerInitial());

            ChannelFuture bindFuture = b.bind(port).sync();

            bindFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        }
        new TelnetServer(port).run();
    }

}
