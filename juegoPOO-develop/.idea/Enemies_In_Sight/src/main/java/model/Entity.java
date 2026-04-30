package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

/**
 * Clase abstracta base para todas las entidades del juego
 *
 */
public abstract class Entity {

    //Constantes

    protected static final int DIR_NONE = 0;
    protected static final int DIR_LEFT = 1;
    protected static final int DIR_UP = 2;
    protected static final int DIR_DOWN = 3;
    public int x;
    public int y;
    //Variabloes no constantes
    private boolean active;
    private BufferedImage sprite;
    private int width;
    private int height;
    private int direction;


    //Constructor por parámetros

    public Entity(int x, int y, BufferedImage sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;

        if (sprite != null) {
            this.width = sprite.getWidth();
            this.height = sprite.getHeight();
        }
        this.active = true;
        this.direction = DIR_NONE;
    }

    //Getters y Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;

        if (sprite != null) {
            this.width = sprite.getWidth();
            this.height = sprite.getHeight();
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDirection() {
        return direction;
    }

    /**
     * Carga una imagen desde la carpeta de recursos.
     * Uso: Entidad.cargarImagen("pacman_left.png")
     */
    public static BufferedImage uploadImage(String nombre) {
        try {
            InputStream is = Entity.class.getResourceAsStream("/resources/images/" + nombre);
            if (is == null) {
                System.err.println("Imagen no encontrada: " + nombre);
                return null;
            }
            return ImageIO.read(is);
        } catch (Exception e) {
            System.err.println("Error cargando imagen: " + nombre);
            return null;
        }
    }



    //Para actualizar

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public abstract void update();

    //Para ver una colisión
    public Rectangle getHitbox() {
        return new Rectangle(x, y, width, height);
    }

    //Para ver una colisión futura
    public Rectangle getHitbox(int px, int py) {
        return new Rectangle(px, py, width, height);

    }

    /**
     * Calcula el desplazamiento horizontal según la dirección actual.
     * Devuelve -1, 0 o +1.
     */
    public int calculateDx() {
        if (direction == DIR_LEFT) return -1;
        return 0;
    }

    /**
     * Calcula el desplazamiento vertical según la dirección actual.
     * Devuelve -1, 0 o +1.
     */
    public int calculateDy() {
        if (direction == DIR_UP) return -1;
        if (direction == DIR_DOWN) return 1;
        return 0;
    }

    public void stand(){

    }

    public void attack(){}

    public void die(){}

    public void ultraAttack(){}

    public void animation(){}

}
