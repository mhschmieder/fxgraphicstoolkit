/**
 * MIT License
 *
 * Copyright (c) 2020, 2023 Mark Schmieder
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * This file is part of the FxGraphicsToolkit Library
 *
 * You should have received a copy of the MIT License along with the
 * FxGraphicsToolkit Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/fxgraphicstoolkit
 */
package com.mhschmieder.fxgraphicstoolkit.geometry;

import java.util.Locale;

/**
 * The <code>Orientation</code> enum is an enumeration for conventional
 * orientation values for graphical objects. For example, it may be relative to
 * a plane cutting through an object's geometric center or COG.
 *
 * NOTE: Other than for string conversions, this is now redundant with JavaFX.
 */
public enum Orientation {
    HORIZONTAL, VERTICAL;

    @SuppressWarnings("nls")
    public static Orientation abbreviatedValueOf( final String abbreviatedOrientation ) {
        if ( "hz".equalsIgnoreCase( abbreviatedOrientation ) ) {
            return HORIZONTAL;
        }

        if ( "vt".equalsIgnoreCase( abbreviatedOrientation ) ) {
            return VERTICAL;
        }

        return defaultValue();
    }

    public static Orientation canonicalValueOf( final String canonicalOrientation ) {
        return ( canonicalOrientation != null )
            ? valueOf( canonicalOrientation.toUpperCase( Locale.ENGLISH ) )
            : defaultValue();
    }

    public static Orientation defaultValue() {
        return HORIZONTAL;
    }

    public final String toAbbreviatedString() {
        String abbreviatedString = null;

        switch ( this ) {
        case HORIZONTAL:
            abbreviatedString = "hz"; //$NON-NLS-1$
            break;
        case VERTICAL:
            abbreviatedString = "vt"; //$NON-NLS-1$
            break;
        default:
            final String errMessage = "Unexpected " //$NON-NLS-1$
                    + this.getClass().getSimpleName() + " " + this; //$NON-NLS-1$
            throw new IllegalArgumentException( errMessage );
        }

        return abbreviatedString;
    }

    public final String toCanonicalString() {
        return toString().toLowerCase( Locale.ENGLISH );
    }

    public final String toPresentationString() {
        String presentationString = null;

        switch ( this ) {
        case HORIZONTAL:
            presentationString = "Horizontal"; //$NON-NLS-1$
            break;
        case VERTICAL:
            presentationString = "Vertical"; //$NON-NLS-1$
            break;
        default:
            final String errMessage = "Unexpected " //$NON-NLS-1$
                    + this.getClass().getSimpleName() + " " + this; //$NON-NLS-1$
            throw new IllegalArgumentException( errMessage );
        }

        return presentationString;
    }

}
