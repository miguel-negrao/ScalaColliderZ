package org.friendlyvirus.mn.ScalaColliderZ
/**
 * Created by Miguel Negrão
 * Copyright Miguel Negrão 2011
 * Licensed under GPL3.0
 */


import de.sciss.synth._
import scalaz.concurrent.Promise


object BufferPromise {

  def alloc( server: Server = Server.default, numFrames: Int, numChannels: Int = 1): Promise[Buffer] =
    makePromise( Buffer.alloc(server, numFrames, numChannels, _) )

  def read( server: Server = Server.default, path: String, startFrame: Int = 0, numFrames: Int = -1): Promise[Buffer] =
    makePromise( Buffer.read(server, path, startFrame, numFrames, _) )

  def cue( server: Server = Server.default, path: String, startFrame: Int = 0, numChannels: Int = 1,
           bufFrames: Int = 32768) : Promise[Buffer] =
    makePromise( Buffer.cue(server, path, startFrame, numChannels, bufFrames, _) )

  def readChannel( server: Server = Server.default, path: String, startFrame: Int = 0, numFrames: Int = -1,
                   channels: Seq[ Int ]) : Promise[Buffer] =
    makePromise( Buffer.readChannel(server, path, startFrame, numFrames, channels, _) )
}

class BufferPromise(b:Buffer) {

  def writeP( path: String, fileType: io.AudioFileType = io.AudioFileType.AIFF,
                sampleFormat: io.SampleFormat = io.SampleFormat.Float, numFrames: Int = -1, startFrame: Int = 0,
                leaveOpen: Boolean = false):Promise[Buffer] =
     makePromise( b.write(path, fileType, sampleFormat, numFrames, startFrame, leaveOpen, _) )
}