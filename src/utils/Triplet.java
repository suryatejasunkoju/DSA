package utils;

public class Triplet <U,V,W>{
    private U u;
    private V v;
    private W w;


    public Triplet(){

    }


    public Triplet(U u, V v, W w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }


    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public W getW() {
        return w;
    }

    public void setW(W w) {
        this.w = w;
    }


    @Override
    public String toString() {
        return "Triplet{" +
                "u=" + u +
                ", v=" + v +
                ", w=" + w +
                '}';
    }
}
