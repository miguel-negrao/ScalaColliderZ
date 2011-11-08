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
import scalaz._
import Scalaz._
import concurrent._
import org.friendlyvirus.mn.ScalaColliderZ._

object Test2 {
  def main(args: Array[String]) {

    Server.test{ s=>
      //change this to a big audio file of your own
      val path = "/Volumes/More Stuff/Audio Projects/Audio Logbook/2011-2012/FullCycle/20/20.aiff"

      println("Creating Promise")

      val ps:List[Promise[Buffer]] = List.fill(10)(path).map( BufferPromise.read(Server.default, _) )

      //sequence takes a List[Promise[Buffer]] and returns a Promise[List[Buffer]]
      //this promise will get it's result when all promises in the list get the result
      ps.sequence.map( buffers => println("All buffers loaded:"+buffers ))

      println("Waiting for buffers to Load")

    }

  }
}