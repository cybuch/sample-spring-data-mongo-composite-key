package ovh.cybuch.composite.key;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeLog
@Slf4j
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "someChangeId", author = "testAuthor")
    public void initLoad(MongoTemplate mongoTemplate){
        log.info("here in mongobee");
        runInOtherThread();
//        sleep();
    }


    private void runInOtherThread() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sleep();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void sleep() {
        try {
            Thread.sleep(12354);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("just woke up");
    }
}