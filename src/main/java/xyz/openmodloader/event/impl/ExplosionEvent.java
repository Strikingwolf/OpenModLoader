package xyz.openmodloader.event.impl;

import net.minecraft.entity.Entity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import xyz.openmodloader.event.Event;
import xyz.openmodloader.event.Events;

public class ExplosionEvent extends Event {
    private World world;
    private Entity entity;
    private double x;
    private double y;
    private double z;
    private float explosionSize;
    private boolean isFlaming;
    private boolean isSmoking;

    public ExplosionEvent(World world, Entity entity, double x, double y, double z, float explosionSize, boolean isFlaming, boolean isSmoking) {
        this.world = world;
        this.entity = entity;
        this.x = x;
        this.y = y;
        this.z = z;
        this.explosionSize = explosionSize;
        this.isFlaming = isFlaming;
        this.isSmoking = isSmoking;
    }

    public World getWorld() {
        return world;
    }

    public Entity getEntity() {
        return entity;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public float getExplosionSize() {
        return explosionSize;
    }

    public void setExplosionSize(float explosionSize) {
        this.explosionSize = explosionSize;
    }

    public boolean isFlaming() {
        return isFlaming;
    }

    public void setFlaming(boolean flaming) {
        isFlaming = flaming;
    }

    public boolean isSmoking() {
        return isSmoking;
    }

    public void setSmoking(boolean smoking) {
        isSmoking = smoking;
    }

    @Override
    public boolean isCancelable() {
        return true;
    }

    public static Explosion onExplosion(World world, Entity entity, double x, double y, double z, float explosionSize, boolean isFlaming, boolean isSmoking) {
        ExplosionEvent event = new ExplosionEvent(world, entity, x, y, z, explosionSize, isFlaming, isSmoking);

        if (Events.EXPLOSION.post(event))
            return null;

        return new Explosion(event.world, event.entity, event.x, event.y, event.z, event.explosionSize, event.isFlaming, event.isSmoking);
    }
}