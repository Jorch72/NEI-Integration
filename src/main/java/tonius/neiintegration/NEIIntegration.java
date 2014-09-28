package tonius.neiintegration;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import tonius.neiintegration.harvestcraft.HarvestCraftIntegration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NEIIntegration.MODID)
public class NEIIntegration {
    
    public static final String MODID = "neiintegration";
    public static final String PREFIX = MODID + ".";
    public static final String RESOURCE_PREFIX = MODID + ":";
    
    @Instance(MODID)
    public static NEIIntegration instance;
    public static Logger log;
    
    public static List<IntegrationBase> integrations = new ArrayList<IntegrationBase>();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent evt) {
        log = evt.getModLog();
        log.info("Starting NEI Integration");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent evt) {
        integrations.add(new HarvestCraftIntegration());
    }
    
}