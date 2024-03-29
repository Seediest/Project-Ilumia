package com.illumidoggies.illumia.common.containers;

import java.util.Objects;

import com.illumidoggies.illumia.common.tiles.TestGUIEntity;
import com.illumidoggies.illumia.core.init.BlockInit;
import com.illumidoggies.illumia.core.init.ContainerTypeInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class TestGUIContainer extends Container{
	public final TestGUIEntity te;
	private final IWorldPosCallable canInteractWithCallable;

	public TestGUIContainer(final int windowId, final PlayerInventory playerInv, final TestGUIEntity te) {
		super(ContainerTypeInit.Test_GUI_CONTAINER_TYPE.get(), windowId);
		this.te = te;
		this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());

		// Tile Entity
		this.addSlot(new Slot((IInventory) te, 0, 80, 35));

		// Main Player Inventory
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));
			}
		}

		// Player Hotbar
		for (int col = 0; col < 9; col++) {
			this.addSlot(new Slot(playerInv, col, 8 + col * 18, 142));
		}
	}

	public TestGUIContainer(final int windowId, final PlayerInventory playerInv, final PacketBuffer data) {
		this(windowId, playerInv, getTileEntity(playerInv, data));
	}

	private static TestGUIEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "Player Inventory cannot be null.");
		Objects.requireNonNull(data, "Packet Buffer cannot be null.");
		final TileEntity te = playerInv.player.world.getTileEntity(data.readBlockPos());
		if (te instanceof TestGUIEntity) {
			return (TestGUIEntity) te;
		}
		throw new IllegalStateException("Tile Entity Is Not Correct");
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.TestGUIEntity.get());
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			if (index < TestGUIEntity.slots
					&& !this.mergeItemStack(stack1, TestGUIEntity.slots, this.inventorySlots.size(), true)) {
				return ItemStack.EMPTY;
			}
			if (!this.mergeItemStack(stack1, 0, TestGUIEntity.slots, false)) {
				return ItemStack.EMPTY;
			}

			if (stack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return stack;
	}

}
