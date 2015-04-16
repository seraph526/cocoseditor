/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionProgressTimer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class JumpTiles3D
    extends TiledGrid3DAction
{
    public native JumpTiles3D clone();

    /**
     * creates the action with the number of jumps, the sin amplitude, the grid size and the duration
     */
    public native static JumpTiles3D create(float duration, @Const @ByRef Size gridSize, int numberOfJumps, float amplitude);

    /**
     * amplitude of the sin
     */
    public native float getAmplitude();

    public native void setAmplitude(float amplitude);

    /**
     * amplitude rate
     */
    public native float getAmplitudeRate();

    public native void setAmplitudeRate(float amplitudeRate);


}
