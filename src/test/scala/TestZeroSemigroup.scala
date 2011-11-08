/*
 *  (ScalaColliderZ)
 *
 *  Copyright (c) 2011 Miguel Negrão All rights reserved.
 *
 *  This software is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either
 *  version 2, june 1991 of the License, or (at your option) any later version.
 *
 *  This software is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public
 *  License (gpl.txt) along with this software; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

import de.sciss.synth._
import ugen._
import scalaz._
import Scalaz._
import org.friendlyvirus.mn.ScalaColliderZ._

object TestZeroSemigroup {
  def main(args: Array[String]) {

    //because GE is semigroup we know how to sum lists of GEs, etc
    (List(SinOsc.ar,Saw.ar):List[GE]).asMA.sum.println

    //Also we can sum Maps with Maps
    val m1:Map[String,GE] = Map("osc"->SinOsc.ar(400))
    val m2:Map[String,GE] = Map("osc"->Saw.ar(500))
    println(m1 |+| m2)

    //because GE is a monoid it knows about it's zero
    val o = none[GE]
    //the same as o getOrElse 0.0
    println(~o)

  }
}