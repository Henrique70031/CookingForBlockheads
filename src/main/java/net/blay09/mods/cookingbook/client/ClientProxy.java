package net.blay09.mods.cookingbook.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.blay09.mods.cookingbook.CommonProxy;
import net.blay09.mods.cookingbook.block.TileEntityFridge;
import net.blay09.mods.cookingbook.block.TileEntityToolRack;
import net.blay09.mods.cookingbook.client.render.FridgeBlockRenderer;
import net.blay09.mods.cookingbook.client.render.TileEntityFridgeRenderer;
import net.blay09.mods.cookingbook.client.render.TileEntityToolRackRenderer;
import net.blay09.mods.cookingbook.client.render.ToolRackBlockRenderer;
import net.minecraftforge.common.MinecraftForge;

@SuppressWarnings("unused")
public class ClientProxy extends CommonProxy {

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);

		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFridge.class, new TileEntityFridgeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityToolRack.class, new TileEntityToolRackRenderer());
		RenderingRegistry.registerBlockHandler(FridgeBlockRenderer.RENDER_ID, new FridgeBlockRenderer());
		RenderingRegistry.registerBlockHandler(ToolRackBlockRenderer.RENDER_ID, new ToolRackBlockRenderer());
	}

	@SubscribeEvent
	public void keyInput(InputEvent.KeyInputEvent event) {}

}
