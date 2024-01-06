import com.example.demo.member.Member;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MemberController {
    HashMap<Long, Member> members = new HashMap<>();

    @GetMapping("/member")
    Map<Long, Member> readMembers() {
        if (members.isEmpty()) return null;
        return members;
    }

    @PostMapping("/member")
    public Member createMember(
            @RequestParam(name="id",defaultValue = "1")
            Long id,
            @RequestParam(name="name",defaultValue = "default")
            String name
    ){

        Member m = new Member(id,name,0);
        members.put(m.getId(), m);
        return m;
    }


}
