select Email from Person where Email in (select Email from Person group by Email having count(Email)>=2 and Id =min(Id))
