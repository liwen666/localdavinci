package auth;

import edp.DavinciServerApplication;
import edp.core.utils.TokenUtils;
import edp.davinci.core.enums.UserOrgRoleEnum;
import edp.davinci.dao.RelUserOrganizationMapper;
import edp.davinci.dao.UserMapper;
import edp.davinci.model.RelUserOrganization;
import edp.davinci.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * <p>
 * 描述
 * </p>
 *
 * @author LW
 * @since 2020/10/28  14:24
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DavinciServerApplication.class)
@Slf4j
public class AuthTest {
    @Autowired
    UserMapper userMapper;


    @Autowired
    private RelUserOrganizationMapper relUserOrganizationMapper;

    @Test
    public void name() {
        String token="eyJhbGciOiJIUzUxMiJ9.eyJ0b2tlbl9jcmVhdGVfdGltZSI6MTYwMzg2NTIxNTgwMCwic3ViIjoiZGF2aW5jaSIsInRva2VuX3VzZXJfbmFtZSI6ImRhdmluY2kiLCJ0b2tlbl91c2VyX3Bhc3N3b3JkIjoiJDJhJDEwJEFjQWRjd3llcHNELjhvc1R1bEdHby5MLnlFaFZ4Rm81SllZU2JGM1RJRklXOC52cjVWSEx5In0.jTqdcjY5z9QN0bcutxGWgNwH5Lx8V9AyXM_X6muXHVjS-TfQObU5buRT1Y-iaRBEve-o1m38kD_eSv-Muam4Gg";
        String username = new TokenUtils().getUsername(token);
        System.out.println(username);
    }
    /**
     * 激活用户
     */
    @Test
    public void setActive() {

        User user = userMapper.getById(2l);
        user.setActive(true);
        user.setUpdateTime(new Date());
        userMapper.activeUser(user);
    }

    /**
     * 组织邀请
     */
    @Test
    public void user_org() {
            Long orgId=2l;
            Long memeberId=4l;

        RelUserOrganization rel = new RelUserOrganization(orgId, memeberId, UserOrgRoleEnum.MEMBER.getRole());
        relUserOrganizationMapper.insert(rel);
    }
}
