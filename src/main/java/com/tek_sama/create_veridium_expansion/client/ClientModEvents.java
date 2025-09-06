// in your client setup (e.g., ClientModEvents)
@Mod.EventBusSubscriber(modid = CreateVeridiumExpansion.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void addLayers(EntityRenderersEvent.AddLayers event) {
        for (String skin : event.getSkins()) {
            var renderer = event.getSkin(skin);
            if (renderer != null) {
                renderer.addLayer(new VeridiumBacktankArmorLayer(renderer));
            }
        }
    }
}
