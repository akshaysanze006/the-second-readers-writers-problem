import java.io.*; 
class writer extends Thread{ 
thr t; 
writer(thr t){ 
this.t=t; 
} 
public void run(){ 
for(int i=1;i<=5;i++){ 
t.write(i); 
System.out.println("Writer is writing "+i); 
try 
{ 
sleep(1000); 
} 
catch(InterruptedException e){} 
} 
} 
} 
class reader extends Thread 
{ 
thr t; 
int val; 
public reader(thr t) 
{ 
this.t=t; 
} 
public void run () 
{ 
for(int i=1;i<=5;i++) 
{ 
val=t.read(); 
System.out.println("\nReader reading "+val); 
try 
{ 
sleep(50); 
} 
catch(InterruptedException e){} 
} 
} 
} 
class thr{ 
boolean lock=false; 
int n; 
synchronized int read(){
18 

while(!lock){ 
try{ 
wait(); 
}catch(InterruptedException e){ 
} 
} 
lock=false; 
notifyAll(); 
return n; 
} 
synchronized void write(int n){ 
while(lock){ 
try{ 
wait(); 
}catch(InterruptedException e){ 
} 
} 
this.n=n; 
lock=true; 
notifyAll(); 
} 
} 
public class rw 
{ 
public static void main (String args[]) 
{ 
thr t =new thr(); 
writer w=new writer(t); 
reader r=new reader(t); 
w.start (); 
r.start (); 
} 
 } 
