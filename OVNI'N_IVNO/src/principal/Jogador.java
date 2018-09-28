/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Gustavo
 */
public class Jogador {

    protected int x = 0;
    protected int y = 0;
    protected ImageIcon img;
    protected boolean cima;
    protected boolean baixo;
    protected boolean direita;
    protected boolean esquerda;
    protected int vida = 3;
    protected int morto = 0;
    protected Rectangle rect = new Rectangle(0, 0, 70, 70);

    public Jogador(String url) {
        img = new ImageIcon(this.getClass().getResource("/").getPath() + url);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        this.rect.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        this.rect.y = y;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public boolean isCima() {
        return cima;
    }

    public void setCima(boolean cima) {
        this.cima = cima;
    }

    public boolean isBaixo() {
        return baixo;
    }

    public void setBaixo(boolean baixo) {
        this.baixo = baixo;
    }

    public boolean isDireita() {
        return direita;
    }

    public void setDireita(boolean direita) {
        this.direita = direita;
    }

    public boolean isEsquerda() {
        return esquerda;
    }

    public void setEsquerda(boolean esquerda) {
        this.esquerda = esquerda;
    }

    public void desenhar(Graphics g) {

        if (img != null) {
            g.drawImage(img.getImage(), x, y, null);
        }
    }

    public void voar() {
        if (cima) {
            y -= 2;
            this.rect.y = y;
        }
        if (baixo) {
            y += 2;
            this.rect.y = y;
        }
        if (esquerda) {
            x -= 2;
            this.rect.x = x;

        }
        if (direita) {
            x += 2;
            this.rect.x = x;
        }
    }

    public boolean colisao(Meteoro meteoro) {
        return rect.intersects(meteoro.rect);
    }
    
        public Colisao trataColisao(int width, int height) {
        Colisao resp = Colisao.NONE;

        if (x < 0) {
            esquerda = false;
            resp = Colisao.LEFT;
        } else if (x > 900) {
            direita = false;
            resp = Colisao.RIGHT;
        }

        if (y < 28) {
            cima = false;
            resp = Colisao.UP;
        } else if (y > 640) {
            baixo = false;
            resp = Colisao.DOWN;
        }

        return resp;
    }
}
