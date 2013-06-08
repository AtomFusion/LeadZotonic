/**
 * 
 */
package dokutoku.lead.zotonic.client;

import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.world.World;

/**
 * Codename: Lead Zotonic
 *
 * CropParticleFX
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public class CropParticleFX extends EntityPortalFX {

	/**
	 * @param par1World
	 * @param par2
	 * @param par4
	 * @param par6
	 * @param par8
	 * @param par10
	 * @param par12
	 */
	public CropParticleFX(World par1World, double par2, double par4,
			double par6, double par8, double par10, double par12, float r, float g, float b) {
		super(par1World, par2, par4, par6, par8, par10, par12);
		
		this.particleRed = r;
        this.particleGreen = g;
        this.particleBlue = b;
        this.setParticleTextureIndex(65);
        //this.setSize(0.01F, 0.01F);
		
	}

}
