# lsystem

Generate L-Systems, and Turtle-execute them

## To Use

Run `lein repl`. Once the REPL is loaded, you can try the provided example with `(def Z (lsystem Z P))` to execute a step of the lsystem. A helper function, `nth-L` is provided to run an lsystem more than once in one go.

The example alphabet is `[:F :< :> :L :R]`. The keywords mean the following:

    :F move forward in the current direction, drawing a line
    :< Push state onto stack
    :> Pop state off stack and use as current state
    :L Turn left
    :R Turn right

The L-System rules are defined as P. You can redifine them. Try this, for example:


    (def P {:F [:F :< :L :F :> :F :< :R :F :> :F]
            :L [:L :F]
            :R [:F :R]})

The graphical window should display real-time results as you redefine values.

WARNING: The system cannot handle deep recursion, hence you cannot run `lsystem` too many times before you get a stack overflow. Sorry.

## To-Do

  * 3D L-System
  * Context-sensitive L-System
  * Panning and zooming of output window
  * Some way to allow deeper recursion...
