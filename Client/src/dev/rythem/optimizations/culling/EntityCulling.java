package dev.rythem.optimizations.culling;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public final class EntityCulling {

	private static Minecraft MC = Minecraft.getMinecraft();
	
	public static boolean shouldRender(final Entity entity)
	{
		final Vec3d self = MC.getRenderManager().renderViewEntity.getPositionVector().addVector(0, MC.getRenderManager().renderViewEntity.getEyeHeight(), 0),
				target = entity.getPositionVector();
		
		final boolean top = MC.world.rayTraceBlocks(self, target, false, true, false) == null,
				bottom = MC.world.rayTraceBlocks(self, target.addVector(0, 1, 0), false, true, false) == null,
				topAllign = MC.world.rayTraceBlocks(self.addVector(0, 0.5, 0), target.addVector(0, 0.5, 0)) == null;
		
		return top || bottom || topAllign;
	}
	
}
