package org.beyondpn.netty.telnet;


import io.netty.channel.*;

import java.net.InetAddress;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-31 下午5:57
 */
@ChannelHandler.Sharable
public class TelnetServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.write("欢迎访问" + InetAddress.getLocalHost().getHostName() + "\r\n");
        ctx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        ChannelFuture future = ctx.writeAndFlush(msg + "\r\n");
        if ("quit".equals(msg)) {
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
