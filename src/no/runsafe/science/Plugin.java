package no.runsafe.science;

import no.runsafe.framework.RunsafePlugin;

public class Plugin extends RunsafePlugin
{
	@Override
	protected void PluginSetup()
	{
		addComponent(PacketTesting.class);
		addComponent(TestPacketCommand.class);
	}
}
