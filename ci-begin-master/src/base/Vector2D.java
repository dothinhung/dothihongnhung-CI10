package base;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(float x, float y ){
        this.x = x;
        this.y = y;
    }

    public Vector2D set(float x, float y){
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     *
     * @return an aother Vector with same x & y
     */
    public Vector2D clone(){
        return new Vector2D(this.x, this.y);
    }

    /**
     * @param x
     * @param y
     * return return new vector  = oldVector + passed arguments
     */

    public Vector2D add(float x, float y){ // tạo mới  tính toán & trả ra kq/ k tác động đến vector gốc
            Vector2D result = new Vector2D(this.x +x, this.y+y);
//            result.x =+ x;
//            result.y += y;
            return result;
    }

    /**
     *
     */

    public Vector2D addThis(float x, float y){ //vector gốc == result
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D subtract(float x, float y){
        return new Vector2D(this.x-x, this.y-y);
    }

    public Vector2D subtractThis(float x, float y){
        this.x -= x;
        this.y -= y;
        return  this;
    }

    public Vector2D scale(float n){
        return new Vector2D(this.x*n, this.y*n);
    }

    public Vector2D scaleThis(float x){
        this.x  *= x;
        this.y *= y;
        return this;
    }

    /**
     *
     * @return vector's length
     */
    public float length(){
        return (float)Math.sqrt(x*x + y*y);
    }

    public void print(){
        System.out.println(x + ";" + y);
    }


    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(10,10);
//        Vector2D result = new Vector2D(5,5);
//        result.add(5,5);
//        result.print();

//        v1.print();
    }
}

/**
 * private chỉ gọi được trong class
 * public truy vẫn được tất
 * protected truy vẫn được trong cùng folder
 *
 * static gắn trực tiếp vào class (không cần tạo đối tượng)
 * non static phải tạo đối tượng ... ví dụ new Test
 * this keyword tương ứng với từng đối tượng được tạo
 */