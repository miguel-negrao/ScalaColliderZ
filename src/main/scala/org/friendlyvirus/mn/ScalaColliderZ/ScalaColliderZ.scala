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

package org.friendlyvirus.mn

import de.sciss.synth._
import scalaz._
import Scalaz._
import concurrent._

package object ScalaColliderZ {

  implicit def synthDefToPromise(s:SynthDef):SynthDefPromise = new SynthDefPromise(s)
  implicit def bufferToPromise(b:Buffer):BufferPromise = new BufferPromise(b)

  def makePromise[T,X](f:Completion[T]=>X):Promise[T] = {
    val promise = emptyPromise[T]
    val c = action( (x:T) => promise.fulfill(x))
    f(c)
    promise
  }

  //typeclasses instances
  implicit def GEZero: Zero[GE] = zero(Constant(0))
  implicit def GESemigroup: Semigroup[GE] = semigroup( _+_ )
  implicit def GEShow: Show[GE] = showA

}