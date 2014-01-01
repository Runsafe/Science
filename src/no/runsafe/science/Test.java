package no.runsafe.science;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.command.player.PlayerCommand;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.extension.block.RunsafeBlock;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.WorldEffect;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.networking.PacketWorldParticle;
import no.runsafe.framework.minecraft.networking.WorldParticleOffset;
import org.bukkit.block.Block;

import java.util.Map;

public class Test extends PlayerCommand
{
	public Test()
	{
		super("test", "Delete test", "runsafe.science");
	}

	@Override
	public String OnExecute(IPlayer executor, Map<String, String> parameters)
	{
		ILocation location = executor.getLocation().clone();
		location.offset(0, -1, 0);
		RunsafeMeta meta = Item.BuildingBlock.Quartz.Chiseled.getItem();
		Block block = ((RunsafeBlock) location.getBlock()).getRaw();
		block.setType(meta.getType());
		block.getState().setData(meta.getRaw().getData());
		block.getState().update();
		executor.sendPacket(new PacketWorldParticle(WorldEffect.MAGIC_CRIT, executor.getLocation(), new WorldParticleOffset(0, 0, 0), 1, 20));
		return "Done";
	}
}
