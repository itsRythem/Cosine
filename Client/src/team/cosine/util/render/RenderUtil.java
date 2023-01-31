package team.cosine.util.render;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

import static org.lwjgl.opengl.GL11.*;

public final class RenderUtil {

	public static void glColor(final int color)
	{
        final float alpha = (float)(color >> 24 & 255) / 255f,
        		red = (float)(color >> 16 & 255) / 255f,
        		green = (float)(color >> 8 & 255) / 255f,
        		blue = (float)(color & 255) / 255f;
        
        GlStateManager.color(red, green, blue, alpha);
	}
	
	public static boolean glToggleBlend(final boolean state)
	{
		final boolean pre = glIsEnabled(GL_BLEND);
		
		if(state)
		{
			GlStateManager.enableBlend();
        	GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		}
		else GlStateManager.disableBlend();
		
		return pre;
	}
	
	public static void glRestoreBlend(final boolean state)
	{
		if(state)
		{
			GlStateManager.enableBlend();
        	GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		}
		else GlStateManager.disableBlend();
	}
	
	public static void drawRect(final double left, final double top, final double right, final double bottom, final int color)
    {
        final Tessellator tessellator = Tessellator.getInstance();
        final BufferBuilder buffer = tessellator.getBuffer();
        
        GlStateManager.disableTexture2D();
        final boolean restore = glToggleBlend(true);
        
        buffer.begin(7, DefaultVertexFormats.POSITION);
        buffer.pos(left, bottom, 0d).endVertex();
        buffer.pos(right, bottom, 0d).endVertex();
        buffer.pos(right, top, 0d).endVertex();
        buffer.pos(left, top, 0d).endVertex();
        tessellator.draw();
        
        glRestoreBlend(restore);
        
        GlStateManager.enableTexture2D();
    }
	
}
