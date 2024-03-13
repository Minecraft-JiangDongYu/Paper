package org.bukkit.craftbukkit.block.impl;

import com.google.common.collect.ImmutableSet;
import io.papermc.paper.generated.GeneratedFrom;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.SculkVein;
import org.bukkit.craftbukkit.block.data.CraftBlockData;

@GeneratedFrom("1.20.4")
@SuppressWarnings("unused")
public class CraftSculkVein extends CraftBlockData implements SculkVein {
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final Map<BlockFace, BooleanProperty> PROPERTY_BY_DIRECTION = Map.of(
        BlockFace.DOWN, BlockStateProperties.DOWN,
        BlockFace.EAST, BlockStateProperties.EAST,
        BlockFace.NORTH, BlockStateProperties.NORTH,
        BlockFace.SOUTH, BlockStateProperties.SOUTH,
        BlockFace.UP, BlockStateProperties.UP,
        BlockFace.WEST, BlockStateProperties.WEST
    );

    public CraftSculkVein(BlockState state) {
        super(state);
    }

    @Override
    public boolean isWaterlogged() {
        return this.get(WATERLOGGED);
    }

    @Override
    public void setWaterlogged(final boolean waterlogged) {
        this.set(WATERLOGGED, waterlogged);
    }

    @Override
    public boolean hasFace(final BlockFace blockFace) {
        return this.get(PROPERTY_BY_DIRECTION.get(blockFace));
    }

    @Override
    public void setFace(final BlockFace blockFace, final boolean face) {
        this.set(PROPERTY_BY_DIRECTION.get(blockFace), face);
    }

    @Override
    public Set<BlockFace> getFaces() {
        ImmutableSet.Builder<BlockFace> faces = ImmutableSet.builder();
        for (BlockFace blockFace : PROPERTY_BY_DIRECTION.keySet()) {
            if (this.get(PROPERTY_BY_DIRECTION.get(blockFace))) {
                faces.add(blockFace);
            }
        }
        return faces.build();
    }

    @Override
    public Set<BlockFace> getAllowedFaces() {
        return Collections.unmodifiableSet(PROPERTY_BY_DIRECTION.keySet());
    }
}
