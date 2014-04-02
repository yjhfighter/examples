package org.beyondpn.netty.telnet;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * a telnet client.
 *
 * @author beyondpn
 *         Create: 14-3-28 下午4:21
 */
public class TelnetClient {

    private final String host;
    private final int port;

    public TelnetClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new TelnetClientHandlerInitializer());

            //start the connection attempt
            Channel ch = b.connect(host, port).sync().channel();

            //read commands from stdin
            ChannelFuture lastWriteFuture = null;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for (; ; ) {
                String line = in.readLine();
                if (line == null) {
                    break;
                }

                lastWriteFuture = ch.writeAndFlush(line + "\r\n");

                if ("quit".equals(line)) {
                    ch.closeFuture().sync();
                    break;
                }
                if (lastWriteFuture != null) {
                    lastWriteFuture.sync();
                }
            }
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage : " + TelnetClient.class.getSimpleName() +
                    " <host> <port>");
            System.exit(1);
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);

        new TelnetClient(host, port).run();
    }

}
