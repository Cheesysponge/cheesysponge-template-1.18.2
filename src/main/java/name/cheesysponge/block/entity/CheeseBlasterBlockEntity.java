package name.cheesysponge.block.entity;

import name.cheesysponge.item.ModItems;
import name.cheesysponge.screen.CheeseBlasterScreenHandler;
import name.cheesysponge.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;



public class CheeseBlasterBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(4,ItemStack.EMPTY);
    public CheeseBlasterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CHEESE_BLASTER, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Cheese Blaster");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new CheeseBlasterScreenHandler(syncId, inv, this);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
    }
    public static void tick(World world, BlockPos pos, BlockState state, CheeseBlasterBlockEntity entity) {
        if(hasRecipe(entity) && hasNotReachedStackLimit(entity)) {
            craftItem(entity);
        }
    }
    private static void craftItem(CheeseBlasterBlockEntity entity) {
        entity.removeStack(0, 1);
        entity.removeStack(1, 1);
        entity.removeStack(2, 1);

        entity.setStack(3, new ItemStack(ModItems.CHEESY_SPONGE_PICKAXE,
                entity.getStack(3).getCount() + 1));
    }
    private static boolean hasRecipe(CheeseBlasterBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == ModItems.BURNING_CHEESE;
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == Items.GOLDEN_PICKAXE;
        boolean hasItemInThirdSlot = entity.getStack(2).getItem() == ModItems.CHEESY_SPONGE;

        return hasItemInFirstSlot && hasItemInSecondSlot && hasItemInThirdSlot;
    }
    private static boolean hasNotReachedStackLimit(CheeseBlasterBlockEntity entity) {
        return entity.getStack(3).getCount() < entity.getStack(3).getMaxCount();
    }


}