package ais.handlers;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.WorldServer;

public class PacketOpenAISInventory implements IMessage, IMessageHandler<PacketOpenAISInventory, IMessage> {
	
	public PacketOpenAISInventory() {}
	
	public PacketOpenAISInventory(EntityPlayer player) {}

	@Override
	public void toBytes(ByteBuf buffer) {}

	@Override
	public void fromBytes(ByteBuf buffer) {}

	@Override
	public IMessage onMessage(PacketOpenAISInventory message, final MessageContext ctx) {		
			ctx.getServerHandler().playerEntity.openGui(ais.instance, ais.GUI, ctx.getServerHandler().playerEntity.worldObj, (int)ctx.getServerHandler().playerEntity.posX, (int)ctx.getServerHandler().playerEntity.posY, (int)ctx.getServerHandler().playerEntity.posZ);
		return null;
	}


}