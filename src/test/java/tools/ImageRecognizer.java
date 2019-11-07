package tools;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.Iterator;

public class ImageRecognizer {

    Screen screen;

    Iterator images;

    private static final Pattern planeImage
            = new Pattern("D:\\Programming\\YandexTest\\src\\test\\resource\\plane.png");
    private static final Pattern busImage = new Pattern("D:\\Programming\\YandexTest\\src\\test\\resource\\bus.png");
    private static final Pattern trainImage =
            new Pattern("D:\\Programming\\YandexTest\\src\\test\\resource\\train.png");


    public ImageRecognizer()
    {
        screen = new Screen();
    }

    public int collectImages()
    {
        return collectQuantityPattern(collectImagesByPattern(planeImage)) +
                collectQuantityPattern(collectImagesByPattern(busImage))+
                collectQuantityPattern(collectImagesByPattern(trainImage));
    }

    public Iterator collectImagesByPattern(Pattern patternImage)
    {
        Iterator iterator;
        try
        {
            iterator = screen.findAll(patternImage);
        }
        catch (FindFailed ex)
        {
            System.out.println("Изображения не найдены");
            return  iterator = null;
        }
        return iterator;
    }

    public int collectQuantityPattern(Iterator iterator)
    {
        int counter = 0;
        if(iterator == null)
        {
            return 0;
        }
        while (iterator.hasNext())
        {

            iterator.next();
            counter++;
        }
        System.out.println(counter);
        return counter;
    }



}
