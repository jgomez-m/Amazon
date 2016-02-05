package org.amazon.solution1;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
    Member m1 = new Member();
    m1.name = "carlos";
    m1.email = "carlos@hotmail.com";
    Member m2 = new Member();
    m2.name = "david";
    m2.email = "david@hotmail.com";
    m2.friends = new ArrayList<Member>();
    Member m4 = new Member();
    m4.name = "member4";
    m4.email = "member4@mail.com";
    m2.friends.add(m4);
    Member m3 = new Member();
    m3.name = "julian";
    m3.email = "julian@hotmail.com";
    m1.friends = new ArrayList<Member>();
    m1.friends.add(m2);
    m1.friends.add(m3);
    printSocialGraph(m1);
 }
 
 private static void printSocialGraph (Member member){
  List<List<Member>> toPrint = new ArrayList<List<Member>>();
  printSocialGraph(member, 0,toPrint);
  for (List<Member> list : toPrint) {
   for (Member member2 : list) {
    System.out.println(member2.name + " - "+member2.email);
   }
  }
 }
 
 static void printSocialGraph (Member member, int level,List<List<Member>> toPrint){
  if (toPrint.size()==level){
   toPrint.add(new ArrayList<Member>());
  }
  toPrint.get(level).add(member);
  if (member.friends==null){
   return ;
  }
  for (Member friend : member.friends) {
   printSocialGraph(friend, level+1, toPrint);
  }
 }
 
 
	 static class Member{
	  String name;
	  String email;
	  List<Member> friends;
	 }
}
