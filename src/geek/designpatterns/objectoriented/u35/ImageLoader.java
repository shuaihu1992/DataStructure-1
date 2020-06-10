package geek.designpatterns.objectoriented.u35;

/**
 * Created by HP on 2020/6/4.
 */
public class ImageLoader{
    private static ImageLoader instance = new ImageLoader();
    private ImageLoader(){}
    public static ImageLoader getInstance(){
        return instance;
    }
}