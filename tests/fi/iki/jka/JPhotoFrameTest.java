package fi.iki.jka;

import org.junit.Test;

import java.awt.event.ActionEvent;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JPhotoFrameTest {
    @Test
    public void testFrameName() throws Exception {
        JPhotoFrame application = new JPhotoFrame(null, (JPhotoCollection)null);

        assertThat(application.getFrameName(), is("[Unsaved]"));
    }

    @Test
    public void testSlideshowWithPhotos5Seconds() throws Exception {
        String[] photos = {
            "/Users/ape08/Desktop/1.jpg",
            "/Users/ape08/Desktop/2.jpg",
            "/Users/ape08/Desktop/3.jpg",
            "/Users/ape08/Desktop/4.jpg"
        };

        JPhotoFrame application = new JPhotoFrame(null, photos);

        ActionEvent event = new ActionEvent(new Object(), 123, JPhotoMenu.A_SLIDESHOW);

        application.actionPerformed(event);

        assertThat(application.interval, is(5000));
    }

    @Test
    public void testSlideshowWithPhotos2Seconds() throws Exception {
        String[] photos = {
            "/Users/ape08/Desktop/1.jpg",
            "/Users/ape08/Desktop/2.jpg",
            "/Users/ape08/Desktop/3.jpg",
            "/Users/ape08/Desktop/4.jpg"
        };

        JPhotoFrame application = new JPhotoFrame(null, photos);

        ActionEvent event = new ActionEvent(new Object(), 123, JPhotoMenu.A_PREVIEW_SLIDESHOW);

        application.actionPerformed(event);

        assertThat(application.interval, is(1000));
    }
}
