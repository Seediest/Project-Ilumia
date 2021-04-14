package com.illumidoggies.illumia.client.entity.render;


import com.illumidoggies.illumia.Illlumia;
import com.illumidoggies.illumia.client.entity.model.IllumiPigModel;
import com.illumidoggies.illumia.common.entities.animal.IllumiPig;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class IllumiPigRender extends MobRenderer<IllumiPig, IllumiPigModel<IllumiPig>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Illlumia.MOD_ID, "textures/entity/hog.png");

    public IllumiPigRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new com.illumidoggies.illumia.client.entity.model.IllumiPigModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(IllumiPig entity) {
        return TEXTURE;
    }
}