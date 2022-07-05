package de.ugur.event.recipes;

import de.ugur.event.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class CraftingRecipes implements Listener {

    private final Main plugin;

    public CraftingRecipes(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().addRecipe(getElytraRecipe());
        plugin.getServer().addRecipe(getShulkerShellRecipe());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(!event.getPlayer().hasDiscoveredRecipe(getElytraRecipe().getKey())){
            event.getPlayer().discoverRecipe(getElytraRecipe().getKey());
        }

        if(!event.getPlayer().hasDiscoveredRecipe(getShulkerShellRecipe().getKey())){
            event.getPlayer().discoverRecipe(getShulkerShellRecipe().getKey());
        }
    }


    public ShapedRecipe getElytraRecipe(){
        ItemStack eltrya = new ItemStack(Material.ELYTRA);
        NamespacedKey elytraKey = new NamespacedKey(plugin,"elytra");
        ShapedRecipe elytraRecipe = new ShapedRecipe(elytraKey, eltrya);
        elytraRecipe.shape("SPS","PNP","S#S");
        elytraRecipe.setIngredient('S', Material.SHULKER_SHELL);
        elytraRecipe.setIngredient('P', Material.PHANTOM_MEMBRANE);
        elytraRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        elytraRecipe.setIngredient('#', Material.AIR);
        return elytraRecipe;
    }

    public ShapedRecipe getShulkerShellRecipe() {
        ItemStack shulkershell = new ItemStack(Material.SHULKER_SHELL);
        NamespacedKey shulkershellKey = new NamespacedKey(plugin,"shulkershell");
        ShapedRecipe shulkershellRecipe = new ShapedRecipe(shulkershellKey, shulkershell);
        shulkershellRecipe.shape(" A ","ABA"," A ");
        shulkershellRecipe.setIngredient('A', Material.NETHERITE_INGOT);
        shulkershellRecipe.setIngredient('B', Material.PAPER);
        return shulkershellRecipe;
    }
}
