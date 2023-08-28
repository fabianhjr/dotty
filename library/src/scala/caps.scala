package scala

import annotation.experimental

@experimental object caps:

  opaque type Root = Unit

  /** The universal capture reference (deprecated) */
  @deprecated("Use `cap` instead")
  val `*`: Root = ()

  /** The universal capture reference */
  val cap: Root = ()

  given Root = cap

  object unsafe:

    extension [T](x: T)
      /** A specific cast operation to remove a capture set.
       *  If argument is of type `T^C`, assume it is of type `T` instead.
       *  Calls to this method are treated specially by the capture checker.
       */
      def unsafeAssumePure: T = x

      /** If argument is of type `cs T`, converts to type `box cs T`. This
      *  avoids the error that would be raised when boxing `*`.
      */
      @deprecated(since = "3.3")
      def unsafeBox: T = x

      /** If argument is of type `box cs T`, converts to type `cs T`. This
       *  avoids the error that would be raised when unboxing `*`.
       */
      @deprecated(since = "3.3")
      def unsafeUnbox: T = x

    extension [T, U](f: T => U)
      /** If argument is of type `box cs T`, converts to type `cs T`. This
       *  avoids the error that would be raised when unboxing `*`.
       */
      @deprecated(since = "3.3")
      def unsafeBoxFunArg: T => U = f

  end unsafe
