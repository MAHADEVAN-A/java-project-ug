
function formval(tf,a)
{
	var check = a;
   var name =tf.xxxx.value;
   if(name==null || name=="")
   {
	   document.getElementById("vald").innerHTML="Enter the Name<br>";
	   tf.xxxx.focus();
	   return false;
   }
   var dob =tf.Dob.value;
   if(dob==null || dob=="")
   {
	   document.getElementById("vald").innerHTML="Enter the Date of Birth<br>";
	   tf.Dob.focus();
	   return false;
   }

   var fname = tf.Fname.value;
   if(fname==null || fname=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Father Name<br>";
	   tf.Fname.focus();
	   return false;
   }
   var foc = tf.Foc.value;
   if(foc==null || foc=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Father Occupation<br>";
	   tf.Foc.focus();
	   return false;
   }
   var mname = tf.Mname.value;
   if(mname==null || mname=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Mother Name<br>";
	   tf.Mname.focus();
	   return false;
   }
   var moc = tf.Moc.value;
   if(moc==null || moc=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Mother Occupation<br>";
	   tf.Moc.focus();
	   return false;
   }
   var strt = tf.Street.value;
   if(strt==null || strt=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Street<br>";
	   tf.Street.focus();
	   return false;
   }
   var are = tf.Area.value;
   if(are==null || are=="")
   {
	   document.getElementById("vald").innerHTML="Enter the Area<br>";
	   tf.Area.focus();
	   return false;
   }
   var pin = tf.Pin.value;
   if(pin==null || pin=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Pincode<br>";
	   tf.Pin.focus();
	   return false;
   }
     if(pin.length<6)
   {
	   document.getElementById("vald").innerHTML="Pinnumber should have atleast 6 digits.<br>";
	   tf.pin.focus();
	   return false;
   }
   if(isNaN(pin))
   {
	   document.getElementById("vald").innerHTML="Invalid Pinnumber<br>";
	   tf.pin.focus();
	   return false;
   }
   var cast = tf.caste.value;
   if(cast==null || cast=="")
   {
	   document.getElementById("vald").innerHTML="Enter your caste<br>";
	   tf.caste.focus();
	   return false;
   }
   var mob = tf.mno.value;
   if(mob==null || mob=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Mobile Number<br>";
	   tf.mno.focus();
	   return false;
   }
   if(mob.length<10)
   {
	   document.getElementById("vald").innerHTML="Mobile number should have atleast 10 digits.<br>";
	   tf.mno.focus();
	   return false;
   }
   if(isNaN(mob))
   {
	   document.getElementById("vald").innerHTML="Invalid phone number<br>";
	   tf.mno.focus();
	   return false;
   }
   var em = tf.eid.value;
   var illegalChars = /[\(\)\<\>\,\;\:\\\/\"\[\]]/;
   var n1=em.indexOf("@");
   var n2=em.lastIndexOf(".");
   if(em==null || em=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Email ID<br>";
	   tf.eid.focus();
	   return false;
   }
   if(em.match(illegalChars))
   {
	   document.getElementById("vald").innerHTML="Invalid Email address<br>";
	   tf.eid.focus();
	   return false;
   }
   if(n1<1 || n2-n1<2)
   {
	   document.getElementById("vald").innerHTML="Invalid Email address<br>";
	   tf.eid.focus();
	   return false;
   }
 if(check==1)
 {
	
   var lan = tf.lan.value;
   if(lan==null || lan=="")
   {
	   document.getElementById("vald").innerHTML="Enter your language mark <br>";
	   tf.lan.focus();
	   return false;
   }
   var egl = tf.eng.value;
   if(egl==null || egl=="")
   {
	   document.getElementById("vald").innerHTML="Enter your english mark <br>";
	   tf.eng.focus();
	   return false;
   }
   var su1 = tf.s1.value;
   if(su1==null || su1=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Subject1 mark<br>";
	   tf.s1.focus();
	   return false;
   }
   var su2 = tf.s2.value;
   if(su2==null || su2=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Subject2 mark<br>";
	   tf.s2.focus();
	   return false;
   }
   var su3 = tf.s3.value;
   if(su3==null || su3=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Subject3 mark<br>";
	   tf.s3.focus();
	   return false;
   }
   var su4 = tf.s4.value;
   if(su4==null || su4=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Subject4 mark<br>";
	   tf.s4.focus();
	   return false;
   }
   var mon = tf.myp.value;
   if(mon==null || mon=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Month and Year of Passing<br>";
	   tf.myp.focus();
	   return false;
   }
    var ugm = tf.ugmajor.selectedIndex;
	  if(ugm<=0)
	  {
		  document.getElementById("vald").innerHTML="Choose your UG Major<br>";
		  tf.ugmajor.focus();
		  return false;
	  }
	  var tgr = tf.tgroup.selectedIndex;
	  if(tgr<=0)
	  {
		  document.getElementById("vald").innerHTML="Choose your 12th group<br>";
		  tf.tgroup.focus();
		  return false;
	  }
 }
 else
 {
	
   var coll= tf.colg.value;
   if(coll==null || coll=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Institution/college last studied<br>";
	   tf.colg.focus();
	   return false;
   }
	 var un = tf.uni.value;
   if(un==null || un=="")
   {
	   document.getElementById("vald").innerHTML="Enter your University last studied<br>";
	   tf.uni.focus();
	   return false;
   }
	 var ys = tf.ystud.value;
   if(ys==null || ys=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Year of Study<br>";
	   tf.ystud.focus();
	   return false;
   }
	 var mobt = tf.mo.value;
   if(mobt==null || mobt=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Marks Obtained<br>";
	   tf.mo.focus();
	   return false;
   }
	 var tmo = tf.tm.value;
   if(tmo==null || tmo=="")
   {
	   document.getElementById("vald").innerHTML="Enter your Total Marks<br>";
	   tf.tm.focus();
	   return false;
   }
	     var ugm = tf.ugmajor.selectedIndex;
	  if(ugm<=0)
	  {
		  document.getElementById("vald").innerHTML="Choose your UG Major<br>";
		  tf.ugmajor.focus();
		  return false;
	  }
	  var pgm = tf.pgmajor.selectedIndex;
	  if(pgm<=0)
	  {
		  document.getElementById("vald").innerHTML="Choose your 12th group<br>";
		  tf.pgmajor.focus();
		  return false;
	  }
 }
      var ge = tf.gen.selectedIndex;
	  if(ge<=0)
	  {
		  document.getElementById("vald").innerHTML="Choose your Gender<br>";
		  tf.gen.focus();
		  return false;
	  }
      var na = tf.nat.selectedIndex;
	    if(na<=0)
	  {
		  document.getElementById("vald").innerHTML="Choose your Nationality<br>";
		  tf.nat.focus();
		  return false;
	  }
	  var mt = tf.mtong.selectedIndex;
	  if(mt<=0)
	  {
		  document.getElementById("vald").innerHTML="Choose your Mother Tongue<br>";
		  tf.mtong.focus();
		  return false;
	  }
	  var re = tf.relg.selectedIndex;
	  if(re<=0)
	  {
		  document.getElementById("vald").innerHTML="Choose your Religion<br>";
		  tf.relg.focus();
		  return false;
	  }
	  var com = tf.comm.selectedIndex;
	  if(com<=0)
	  {
		  document.getElementById("vald").innerHTML="Choose your Community<br>";
		  tf.comm.focus();
		  return false;
	  }
	  var dist = tf.district.selectedIndex;
	  if(dist<=0)
	  {
		  document.getElementById("vald").innerHTML="Choose your Native District<br>";
		  tf.district.focus();
		  return false;
	  }
	  var cate = tf.cat.selectedIndex;
	  if(cate<=0)
	  {
		  document.getElementById("vald").innerHTML="Choose your Stream<br>";
		  tf.cat.focus();
		  return false;
	  }
	 
	  window.onerror = function(ermessage,url,line)
	  {
		  document.getElementById("vald").innerHTML=ermessage+"<br>"+line;
	  }
}
