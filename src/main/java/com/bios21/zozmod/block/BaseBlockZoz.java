package com.bios21.zozmod.block;

import com.bios21.zozmod.core.IBlockItem;
import com.bios21.zozmod.creativetab.CreativeTabsZoz;
import com.bios21.zozmod.reference.Reference;
import com.bios21.zozmod.utils.ZozUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Asus on 21/06/2015.
 */
public class BaseBlockZoz extends Block implements IBlockItem {
    protected final String name;

    float sizeX = 1f;
    float sizeY = 1f;
    float sizeZ = 1f;

    public BaseBlockZoz(final Material material, final String name) {
        super(material);
        this.setCreativeTab(CreativeTabsZoz.ZOZ_MAIN_TAB);
        this.name = name;
        this.setSize();
    }

    public BaseBlockZoz(final String name) {
        this(Material.ground, name);
    }

    @Override
    public String getUnlocalizedName() {
        final StringBuilder sbName = new StringBuilder("tile.");
        sbName.append(Reference.MOD_ID.toLowerCase()).append(":");
        sbName.append(this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));

        return sbName.toString();
    }

    @Override
    public String getTextureName() {
        return String.format("%s:%s", Reference.MOD_ID.toLowerCase(), this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isBlock() {
        return true;
    }

    @Override
    public boolean isItem() {
        return false;
    }

    protected String getUnwrappedUnlocalizedName(final String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    public AxisAlignedBB getCustomBoundingBox(final int x, final int y, final int z) {
        return AxisAlignedBB.fromBounds(x+this.minX, y+this.minY, z+this.minZ, x+this.maxX, y+this.maxY, z+this.maxZ);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
        return this.getCustomBoundingBox(pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos) {
        return this.getCustomBoundingBox(pos.getX(), pos.getY(), pos.getZ());
    }

    private void setSize() {
        this.setSize(this.sizeX, this.sizeY, this.sizeZ);
    }

    public void setSize(final float x, final float y, final float z) {
        this.sizeX = x;
        this.sizeY = y;
        this.sizeZ = z;

        this.minX = (1f - this.sizeX)/2;
        this.minY = 0f;
        this.minZ = (1f - this.sizeZ)/2;
        this.maxX = 1f - this.minX;
        this.maxY = this.sizeY;
        this.maxZ = 1f - this.minZ;
    }

    public void setSize(final int x, final int y, final int z) {
        this.setSize(ZozUtils.pixelToFloat(x), ZozUtils.pixelToFloat(y), ZozUtils.pixelToFloat(z));
    }
}
