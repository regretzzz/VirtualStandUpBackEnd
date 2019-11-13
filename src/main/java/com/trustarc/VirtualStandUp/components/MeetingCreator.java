package com.trustarc.VirtualStandUp.components;

import com.trustarc.VirtualStandUp.entity.Meeting;
import com.trustarc.VirtualStandUp.entity.MeetingStatus;
import com.trustarc.VirtualStandUp.entity.Team;
import com.trustarc.VirtualStandUp.repository.MeetingJpaRepository;
import com.trustarc.VirtualStandUp.repository.TeamJpaRespository;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
@NoArgsConstructor
public class MeetingCreator {
    private static final Logger LOG = LoggerFactory.getLogger(MeetingCreator.class);

    @Autowired
    public  MeetingJpaRepository meetingJpaRepository;
    @Autowired
    public  TeamJpaRespository teamJpaRespository;





    @Scheduled(cron = "0 0 6 * * ?")
    public void AddNewDailyStandUp(){
        final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        List<Team> teams = teamJpaRespository.findAll();
        final long ONE_MINUTE_MILIS = 60000;
        teams.forEach(team -> {

            Meeting temp = new Meeting();
            Calendar cal = Calendar.getInstance();

            cal.set(Calendar.HOUR_OF_DAY,team.getStandupTime().getHours());
            cal.set(Calendar.MINUTE,team.getStandupTime().getMinutes());
            cal.set(Calendar.SECOND,0);
            cal.set(Calendar.MILLISECOND,0);

            Date d = cal.getTime();
            temp.setEndDate(d);
            long time = team.getStandupTime().getTime();
            Date end = new Date(time + (15* ONE_MINUTE_MILIS));
            cal.set(Calendar.MINUTE,end.getMinutes());
            d = cal.getTime();
            temp.setStartDate(d);

            temp.setMeetingDescription("Daily Stand Up -"+ formatter.format(d));
            temp.setMeetingSubject("Daily Stand Up");
            temp.setStatus(MeetingStatus.INCOMING);
            temp.setTeam(team);
            meetingJpaRepository.save(temp);
            LOG.debug("Meeting created!");
        });



    }
   // @Scheduled(fixedDelay = 10)
    public void UpdateStatus(){
        Calendar cal1 = Calendar.getInstance();

        cal1.set(Calendar.HOUR_OF_DAY,13);
        cal1.set(Calendar.MINUTE,0);
        cal1.set(Calendar.SECOND,0);
        cal1.set(Calendar.MILLISECOND,0);
        Calendar cal2 = Calendar.getInstance();

        cal2.set(Calendar.HOUR_OF_DAY,13);
        cal2.set(Calendar.MINUTE,15);
        cal2.set(Calendar.SECOND,0);
        cal2.set(Calendar.MILLISECOND,0);
        LOG.debug("Updated Checking!");
        Date currentDate = Calendar.getInstance().getTime();
        if(currentDate.compareTo(cal1.getTime()) >= 0 && currentDate.compareTo(cal2.getTime()) < 0 )
        {
            List<Meeting> meetings = meetingJpaRepository.findAllByStartDate(cal1.getTime());
            meetings.forEach( meeting -> {
                meeting.setStatus(MeetingStatus.ON_GOING);
                meetingJpaRepository.save(meeting);
                LOG.debug("Updated Meeting!");
            });
        } else if (currentDate.compareTo(cal2.getTime()) > 0){
            List<Meeting> meetings = meetingJpaRepository.findAllByEndDate(cal2.getTime());
            meetings.forEach( meeting -> {
                meeting.setStatus(MeetingStatus.DONE);
                meetingJpaRepository.save(meeting);
                LOG.debug("Updated Meeting!");
            });

        }
    }
}
