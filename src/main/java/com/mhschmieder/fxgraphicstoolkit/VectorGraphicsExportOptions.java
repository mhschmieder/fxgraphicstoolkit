/**
 * MIT License
 *
 * Copyright (c) 2020, 2022 Mark Schmieder
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
package com.mhschmieder.fxgraphicstoolkit;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * These are the Export Options for Vector Graphics Export. By default,
 * everything is exported, and this also covers under-specified cases. All
 * options are mutually exclusive as otherwise an empty export could result.
 */
public final class VectorGraphicsExportOptions extends GraphicsExportOptions {

    // NOTE: Not all vector graphics formats support titles.
    protected final StringProperty title;

    // Default constructor when nothing is known.
    @SuppressWarnings("nls")
    public VectorGraphicsExportOptions() {
        this( "", EXPORT_ALL_DEFAULT, EXPORT_CHART_DEFAULT, EXPORT_AUXILIARY_DEFAULT );
    }

    // Fully specified constructor when everything is known.
    public VectorGraphicsExportOptions( final String pTitle,
                                        final boolean pExportAll,
                                        final boolean pExportChart,
                                        final boolean pExportAuxiliary ) {
        super( pExportAll, pExportChart, pExportAuxiliary );

        title = new SimpleStringProperty( pTitle );
    }

    // Copy constructor.
    public VectorGraphicsExportOptions( final VectorGraphicsExportOptions pVectorGraphicsExportOptions ) {
        this( pVectorGraphicsExportOptions.getTitle(),
              pVectorGraphicsExportOptions.isExportAll(),
              pVectorGraphicsExportOptions.isExportChart(),
              pVectorGraphicsExportOptions.isExportAuxiliary() );
    }

    public String getTitle() {
        return title.get();
    }

    // Default pseudo-constructor.
    @SuppressWarnings("nls")
    @Override
    public void reset() {
        super.reset();

        setTitle( "" );
    }

    public void setTitle( final String pTitle ) {
        title.set( pTitle );
    }

    // Fully specified pseudo-constructor.
    public void setVectorGraphicsExportOptions( final String pTitle,
                                                final boolean pExportAll,
                                                final boolean pExportChart,
                                                final boolean pExportAuxiliary ) {
        setGraphicsExportOptions( pExportAll, pExportChart, pExportAuxiliary );

        setTitle( pTitle );
    }

    // Pseudo-copy constructor.
    public void setVectorGraphicsExportOptions( final VectorGraphicsExportOptions pVectorGraphicsExportOptions ) {
        setVectorGraphicsExportOptions( pVectorGraphicsExportOptions.getTitle(),
                                        pVectorGraphicsExportOptions.isExportAll(),
                                        pVectorGraphicsExportOptions.isExportChart(),
                                        pVectorGraphicsExportOptions.isExportAuxiliary() );
    }

    public StringProperty titleProperty() {
        return title;
    }

}
